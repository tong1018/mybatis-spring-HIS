package com.ct.service.inf;

import com.ct.entity.Patient;
import com.ct.entity.RegInfo;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface RegisterInterface {

    public Patient getPatientInfoByID(int medRecID);


//    public int newPatient(Patient patient);

   // public int getRegLevel(int doc_id);


    //测试接口
    public Object test(String name, int sex, int age, Date birthDate, String address, String identityID);

    //自动获取患者信息
    public Patient getPatientInfoByIdentity(String identityID);

    //添加挂号信息
    public RegInfo insertRegInfo(int docID, int deptID, int medRecID, String noonType, int isNeedBook, Date diagTime, int regLevelID,int operatorID ,String name, int sex, int age, Date birthDate, String address, String identityID,int invoiceCode) ;

    //显示页面选项参数
    public Map<String, List<Object>> getDisplayItems();

    //显示某个科室的所有医生
    public List<Object> getDocsByDept(String name);
}
