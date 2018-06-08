package com.khidi.manager.externaldata.controller;

import com.khidi.common.utils.DateUtils;
import com.khidi.common.utils.JSONUtil;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.entity.ResourceStationEntity;
import com.khidi.manager.basicinfo.service.ResourceStationService;
import com.khidi.manager.basicinfo.service.impl.ResourceStationServiceImpl;
import com.khidi.manager.externaldata.entity.EcoCompensationEntity;
import com.khidi.manager.externaldata.entity.ExternalAttributeEntity;
import com.khidi.manager.externaldata.entity.ExternalLinkEntity;
import com.khidi.manager.externaldata.entity.ExternalWqDataEntity;
import com.khidi.manager.externaldata.service.EcoCompensationService;
import com.khidi.manager.externaldata.service.ExternalAttributeService;
import com.khidi.manager.externaldata.service.ExternalLinkService;
import com.khidi.manager.externaldata.service.ExternalWqDataService;
import com.khidi.manager.monitoringnet.entity.DataAirEntity;
import com.khidi.manager.monitoringnet.entity.WaterqualitydataEntity;
import com.khidi.manager.monitoringnet.service.DataAirService;
import com.khidi.manager.monitoringnet.service.WaterqualitydataService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.*;


/**
 * Created by Administrator on 2018/1/17.
 */
@Component
public class GetExternalDataTask {
    @Autowired
    private ExternalLinkService externalLinkService;
    @Autowired
    private ExternalAttributeService externalAttributeService;
    @Autowired
    private EcoCompensationService ecoCompensationService;
    @Autowired
    private ExternalWqDataService externalWqDataService;
    @Autowired
    private ResourceStationService resourceStationService;
    @Autowired
    private WaterqualitydataService waterqualitydataService;
    @Autowired
    private DataAirService dataAirService;




    //每天凌晨1点执行一次该任务
//    @Scheduled(cron="0 0 1 * * ?")
    @Scheduled(cron="0 30 * * * ?")
    //每月获取生态补偿金
    public void getEcoData() throws  Exception{
        //设置查询补偿金条件设置
        Map<String,Object> map = new HashedMap();
        //设置查询区域
        map.put("area","昆明市");
        //是否启用
        map.put("enable","是");
        //连接该表表示和生态补偿金进行对接
        map.put("linkTable","EXTERNAL_ECO_COMPENSATION");
        //每部署一个地方保证只能找到生态补偿金的一条记录
        ExternalLinkEntity entity = externalLinkService.queryList(map).get(0);
        String authPath = entity.getUrl();
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> parMap = new HashMap<String, Object>();
        parMap.put("DATATIME", DateUtils.plusOneMonth(entity.getNewDataTime()));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<String,Object>();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", entity.getAuthorization());
        headers.set("Allow",entity.getMethod());

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<MultiValueMap<String, Object>>(param, headers);
        String jsonObject = restTemplate.postForObject(authPath,requestEntity,String.class,parMap);
        //将json格式的数据转化成list<map<String,object>>
        List<Map<String,Object>> mapListJson = JSONUtil.toList(jsonObject);
        //开始取数据了
        Map<String,Object> queryAttrMap = new HashedMap();
        queryAttrMap.put("linkId",entity.getId());
        List<ExternalAttributeEntity> attrList= externalAttributeService.queryList(queryAttrMap);
        List<EcoCompensationEntity> resultList = new ArrayList<>();
        for(int i=0;i<mapListJson.size();i++){
            Map<String, Object> obj = mapListJson.get(i);
            EcoCompensationEntity eco = new EcoCompensationEntity();
            Class type = EcoCompensationEntity.class;
            for (Map.Entry<String, Object> entry : obj.entrySet()) {
                for(int k=0;k<attrList.size();k++){
                    if(entry.getKey().equals(attrList.get(k).getOriginAttr())){
                        String setMethod = StringUtil.createSetFunctionName(attrList.get(k).getDestAttr());
                        Class destType = Class.forName(attrList.get(k).getDestType());
                        Object strval1 = entry.getValue();
                        Method m = type.getDeclaredMethod(setMethod,destType);
                        m.invoke(eco,strval1.toString());
                    }
                }
            }
            resultList.add(eco);
        }
        //表示有数据可以数据
        if(resultList.size()>0){
            entity.setNewDataTime(DateUtils.plusOneMonth(entity.getNewDataTime()));
            externalLinkService.update(entity);
        }
        //对补偿金的数据进行对比，如果数据库中不存在，就插入数据库
        List<EcoCompensationEntity> tempList = ecoCompensationService.queryList(new HashedMap());
        //将数据库中id存入set中
        Set<String> set = new HashSet<>();
        for(EcoCompensationEntity ecoentity :tempList){
            set.add(ecoentity.getId());
        }
        //对结果集和s数据库中id对比，不存在则插入新的生态补偿金
       for(EcoCompensationEntity resultentity:resultList){
            if(!set.contains(resultentity.getId())){
                ecoCompensationService.save(resultentity);
                set.add(resultentity.getId());
            }
       }
    }



    //获取滇管局水质最新数据
    //滇管局水质数据4小时一次更新，每个小时都拉取一次
//    @Scheduled(cron="0 0 */3 * * ?")
    @Scheduled(cron="0 20 * * * ?")
    //获取水质最新数据
    public void getWQDataFromDGJ() throws  Exception{
        //设置查询补偿金条件设置
        Map<String,Object> map = new HashedMap();
        //设置查询区域
        map.put("area","昆明市");
        //是否启用
        map.put("enable","是");
        //连接该表表示和水质数据进行对接
        map.put("linkTable","EXTERNAL_WQ_DATA");
        //每部署一个地方保证只能找到生态补偿金的一条记录
        ExternalLinkEntity entity = externalLinkService.queryList(map).get(0);
        String authPath = entity.getUrl();
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, Object> param = new LinkedMultiValueMap<String,Object>();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", entity.getAuthorization());
        headers.set("Accept-Charset", "utf-8");
        headers.set("Allow","HttpMethod.GET");

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<MultiValueMap<String, Object>>(param, headers);

        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("stationType","1");
        queryMap.put("dataOrgin","滇管局");
        List<ResourceStationEntity> wqStationList =  resourceStationService.queryList(queryMap);
        for(ResourceStationEntity stationEntity:wqStationList){
            //构造一个水质实体
            WaterqualitydataEntity wqdentity = new WaterqualitydataEntity();
            wqdentity.setStationId(stationEntity.getId());

            Map<String, Object> parMap = new HashMap<String, Object>();
            parMap.put("MN", stationEntity.getCode());
            ResponseEntity<String> jsonObject = restTemplate.exchange(authPath,HttpMethod.GET, requestEntity, String.class, parMap);
            List<Map<String,Object>> mapListJson = JSONUtil.toList(jsonObject.getBody());
            //开始取数据了
            Map<String,Object> queryAttrMap = new HashedMap();
            queryAttrMap.put("linkId",entity.getId());
            List<ExternalAttributeEntity> attrList= externalAttributeService.queryList(queryAttrMap);
            List<ExternalWqDataEntity> resultList = new ArrayList<>();
            for(int i=0;i<mapListJson.size();i++){
                Map<String, Object> obj = mapListJson.get(i);
                ExternalWqDataEntity eco = new ExternalWqDataEntity();
                Class type = ExternalWqDataEntity.class;
                for (Map.Entry<String, Object> entry : obj.entrySet()) {
                    for(int k=0;k<attrList.size();k++){
                        if(entry.getKey().equals(attrList.get(k).getOriginAttr())){
                            String setMethod = StringUtil.createSetFunctionName(attrList.get(k).getDestAttr());
                            Class destType = Class.forName(attrList.get(k).getDestType());
                            Object strval1 = entry.getValue();
                            Method m = type.getDeclaredMethod(setMethod,destType);
                            m.invoke(eco,strval1.toString());
                        }
                    }
                }
                eco.setStationId(stationEntity.getCode());
                resultList.add(eco);
            }
            //表示有数据可以数据
            if(resultList.size()>0){
                entity.setNewDataTime(DateUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
                externalLinkService.update(entity);
            }
            //对水质数据进行对比，如果数据库中不存在，就插入数据库
            List<ExternalWqDataEntity> tempList = externalWqDataService.queryList(new HashedMap());
            //将数据库中id存入set中
            Set<String> set = new HashSet<>();
            for(ExternalWqDataEntity wqentity :tempList){
                set.add(wqentity.getId());
            }
            //对结果集和s数据库中id对比，不存在则插入新的水质数据


            for(ExternalWqDataEntity resultentity:resultList){
                if(!set.contains(resultentity.getId())){
                    externalWqDataService.save(resultentity);
                    //将拉取到的数据添加到Waterqualitydata表中
                    wqdentity.setCreatetime(DateUtils.json2Date(resultentity.getMonitorTime()));
                    if(resultentity.getItem().equals("pH")){
                        wqdentity.setPh(resultentity.getValue());
                    }else if(resultentity.getItem().equals("CODcr")){
                        wqdentity.setCod(resultentity.getValue());
                    }else if(resultentity.getItem().equals("氨氮")){
                        wqdentity.setNh(resultentity.getValue());
                    }else if(resultentity.getItem().equals("总磷")){
                        wqdentity.setPhosphor(resultentity.getValue());
                    }
                    set.add(resultentity.getId());
                }
            }
            if(wqdentity.getCreatetime() != null){
                waterqualitydataService.save(wqdentity);
            }
        }
    }




    //获取空气质量最新数据
    //滇管局水质数据4小时一次更新，每个小时都拉取一次
//    @Scheduled(cron="0 0 */3 * * ?")
    @Scheduled(cron="0/30 * * * * ?")
    //获取水质最新数据
    public void getAirData() throws  Exception{
        //设置查询补偿金条件设置
        Map<String,Object> map = new HashedMap();
        //设置查询区域
        map.put("area","昆明市");
        //是否启用
        map.put("enable","是");
        //连接该表表示和生态补偿金进行对接
        map.put("linkTable","DATA_AIR");
        //每部署一个地方保证只能找到生态补偿金的一条记录
        ExternalLinkEntity entity = externalLinkService.queryList(map).get(0);
        String authPath = entity.getUrl();
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, Object> param = new LinkedMultiValueMap<String,Object>();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<MultiValueMap<String, Object>>(param, headers);

        ResponseEntity<String> jsonObject = restTemplate.exchange(authPath,HttpMethod.GET, requestEntity, String.class);

//
        Map<String, Object> resultmap = JSONUtil.toMap(jsonObject.getBody());

        for (Map.Entry<String, Object> entry : resultmap.entrySet()) {
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
        //获取到更新时间
        String monitorTime = resultmap.get("update").toString();
        //获取中括号里面内容
        List<Map<String,Object>> mapListJson = JSONUtil.toList(JSONUtil.getJson(jsonObject.getBody()));
            //开始取数据了
            Map<String,Object> queryAttrMap = new HashedMap();
            queryAttrMap.put("linkId",entity.getId());
            List<ExternalAttributeEntity> attrList= externalAttributeService.queryList(queryAttrMap);
            List<DataAirEntity> resultList = new ArrayList<>();
            for(int i=0;i<mapListJson.size();i++){
                Map<String, Object> obj = mapListJson.get(i);
                DataAirEntity air = new DataAirEntity();
                Class type = DataAirEntity.class;
                for (Map.Entry<String, Object> entry : obj.entrySet()) {
                    for(int k=0;k<attrList.size();k++){
                        if(entry.getKey().equals(attrList.get(k).getOriginAttr())){
                            String setMethod = StringUtil.createSetFunctionName(attrList.get(k).getDestAttr());
                            Class destType = Class.forName(attrList.get(k).getDestType());
                            Object strval1 = entry.getValue();
                            Method m = type.getDeclaredMethod(setMethod,destType);
                            m.invoke(air,strval1.toString());
                        }
                    }
                }
                resultList.add(air);
            }
//            如果找到的最新数据和上次存的不一致，就保存数据并更新最近一次拉取时间，
            if(!monitorTime.equals(entity.getNewDataTime())){
                for(DataAirEntity airEntity:resultList){
                    airEntity.setMonitorTime(monitorTime);
                    dataAirService.save(airEntity);
                }
                entity.setNewDataTime(monitorTime);
                externalLinkService.update(entity);
            }
        }
    }
