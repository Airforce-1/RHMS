package com.khidi.manager.basicinfo.service.impl;
import com.khidi.common.utils.OfficeToPdf;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.List;
import java.util.Map;
import com.khidi.manager.basicinfo.dao.ResourceFileDao;
import com.khidi.manager.basicinfo.entity.ResourceFileEntity;
import com.khidi.manager.basicinfo.service.ResourceFileService;
import org.springframework.web.multipart.MultipartFile;
@Service("resourceFileService")
public class ResourceFileServiceImpl implements ResourceFileService {
	@Autowired
	private ResourceFileDao resourceFileDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	@Autowired
	private SysDictDao sysDictDao;
	
	@Override
	public ResourceFileEntity queryObject(String id){
		return resourceFileDao.queryObject(id);
	}
	
	@Override
	public List<ResourceFileEntity> queryList(Map<String, Object> map){
		List<ResourceFileEntity> list= resourceFileDao.queryList(map);

		for(int i = 0;i < list.size();i++){
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());

			Map<String,Object> querymap =  new HashMap();

			if (StringUtil.isEmpty(list.get(i).getFiletype())) {
				list.get(i).setFiletypeName(null);
			}else{
				list.get(i).setFiletypeName(sysDictDao.queryObjectbyId(list.get(i).getFiletype()).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getRiverType())) {
				list.get(i).setRiverTypeName(null);
			} else {
				list.get(i).setRiverTypeName(sysDictDao.queryObjectbyId(list.get(i).getRiverType()).getDictName());
			}
		}
	    return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resourceFileDao.queryTotal(map);
	}
	
	@Override
	public void save(ResourceFileEntity resourceFile){
		resourceFile.setId(UUID.randomUUID().toString());
		resourceFileDao.save(resourceFile);
	}


	@Override
	public Map<String, Object> upload(MultipartFile file, String filePath) {
		ResourceFileEntity resourceFile = new ResourceFileEntity();
		resourceFile.setId(UUID.randomUUID().toString());  //设置主键
		resourceFile.setFileSize(String.valueOf(file.getSize()));
		resourceFile.setName(file.getOriginalFilename());

		try {
			File input = new File(filePath + resourceFile.getName());
			file.transferTo(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String kind = OfficeToPdf.getFileSufix(resourceFile.getName());
		if (kind.equals("doc") || kind.equals("docx") || kind.equals("txt")) {
			OfficeToPdf.word2PDF(filePath + resourceFile.getName(), filePath + OfficeToPdf.changeFileSufix(resourceFile.getName()));
			resourceFile.setName(OfficeToPdf.changeFileSufix(resourceFile.getName()));
		}else if (kind.equals("ppt")||kind.equals("pptx")) {
			OfficeToPdf.ppt2PDF(filePath + resourceFile.getName(), filePath + OfficeToPdf.changeFileSufix(resourceFile.getName()));
			resourceFile.setName(OfficeToPdf.changeFileSufix(resourceFile.getName()));
		}else if(kind.equals("xls")||kind.equals("xlsx")){
			OfficeToPdf.Ex2PDF(filePath + resourceFile.getName(), filePath + OfficeToPdf.changeFileSufix(resourceFile.getName()));
			resourceFile.setName(OfficeToPdf.changeFileSufix(resourceFile.getName()));
		}
		resourceFile.setFilePath("/uploadfiles/"+resourceFile.getName());
		Map<String, Object> map = new HashMap();
		map.put("filePath", resourceFile.getFilePath());
		map.put("fileType", resourceFile.getFiletype());
		map.put("fileSize", resourceFile.getFileSize());
		map.put("fileName", resourceFile.getName());
		return map;
	}


	
	@Override
	public void update(ResourceFileEntity resourceFile){
		resourceFileDao.update(resourceFile);
	}
	
	@Override
	public void delete(String id){
		StringBuilder sbf = new StringBuilder();
		ResourceFileEntity resourceFile = resourceFileDao.queryObject(id);
		String fileName = sbf.append(resourceFile.getFilePath()).append(resourceFile.getName()).toString();
		System.out.println(sbf);
		File file = new File(fileName);
		if(file.isFile() && file.exists()){
			file.delete();
			System.out.println("删除单个文件"+fileName+"成功！");
		}else{
			System.out.println("删除单个文件"+fileName+"失败！");
		}

		resourceFileDao.delete(id);
	}
}
