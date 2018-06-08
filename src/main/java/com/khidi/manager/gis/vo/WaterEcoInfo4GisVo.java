package com.khidi.manager.gis.vo;

import com.khidi.manager.externaldata.entity.EcoCompensationEntity;
import com.khidi.manager.officework.entity.CheckrecordEntity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/1/29.
 */
public class WaterEcoInfo4GisVo extends EcoCompensationEntity {
    private String aim4Cod;  //cod的目标值
    private String aim4nh;   //氨氮的目标值
    private String aim4P;    //总磷的目标值
    private String codFlag;  //相比上月cod的涨落平
    private String nhFlag;  //相比上月氨氮的涨落平
    private String pFlag;  //相比上月总磷的涨落平
    private String MonTime;//水质实时监测数据时间
    private String aimLevel; //实时数据目标水质
    private String currentLevel;//实时数据当前水质
    private String cod4Now;//实时数据cod含量
    private String nh4Now;//实时数据氨氮含量
    private String p4Now;//实时数据总磷含量



    //将父类的属性赋给子类
    public void setEcoCompensationEntity(EcoCompensationEntity val){
        Class<?> type = EcoCompensationEntity.class;
        Field[] fields = type.getDeclaredFields();
        try{
            for(Field field : fields){
                String fieldName = field.getName();
                if(fieldName.equals("serialVersionUID")) continue;
                String getMethodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                Method getMethod = type.getDeclaredMethod(getMethodName);
                Object o = getMethod.invoke(val);
                String setMethodName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                Method setMethod = this.getClass().getMethod(setMethodName,field.getType());
                setMethod.invoke(this,o);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getMonTime() {
        return MonTime;
    }

    public void setMonTime(String monTime) {
        MonTime = monTime;
    }

    public String getCod4Now() {
        return cod4Now;
    }

    public void setCod4Now(String cod4Now) {
        this.cod4Now = cod4Now;
    }

    public String getNh4Now() {
        return nh4Now;
    }

    public void setNh4Now(String nh4Now) {
        this.nh4Now = nh4Now;
    }

    public String getP4Now() {
        return p4Now;
    }

    public void setP4Now(String p4Now) {
        this.p4Now = p4Now;
    }

    public String getAim4Cod() {
        return aim4Cod;
    }

    public void setAim4Cod(String aim4Cod) {
        this.aim4Cod = aim4Cod;
    }

    public String getAim4nh() {
        return aim4nh;
    }

    public void setAim4nh(String aim4nh) {
        this.aim4nh = aim4nh;
    }

    public String getAim4P() {
        return aim4P;
    }

    public void setAim4P(String aim4P) {
        this.aim4P = aim4P;
    }

    public String getCodFlag() {
        return codFlag;
    }

    public void setCodFlag(String codFlag) {
        this.codFlag = codFlag;
    }

    public String getNhFlag() {
        return nhFlag;
    }

    public void setNhFlag(String nhFlag) {
        this.nhFlag = nhFlag;
    }

    public String getpFlag() {
        return pFlag;
    }

    public void setpFlag(String pFlag) {
        this.pFlag = pFlag;
    }



    public String getAimLevel() {
        return aimLevel;
    }

    public void setAimLevel(String aimLevel) {
        this.aimLevel = aimLevel;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }


}
