package com.ct.mapper;

import com.ct.entity.Patient;
import com.ct.entity.RegInfo;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RegisterMapper {

    //通过病历号获取病人信息
    public Patient getPatient(int redMecID);

    //根据身份证获取病历号
    public int getMedRecIDByIdentity(String identityID);

    //通过挂号等级ID获取挂号的费用
    public BigDecimal getRegLevelFee(int regID);

    public Patient getPatientByIdentity(String identityID);

    //添加新的病人信息
    public int newPatient(Patient patient);


   //挂号
    public int insertRegInfo(RegInfo regInfo);

    //显示所有医生 userType=3
    public List<Object> getAllDoc();

    //显示所有的科室
    public List<Object> getAllDept();

    //显示所有的挂号等级
    public List<Object> getAllRegLevel();



    //选择科室后显示对应医生
    public List<Object> getDocsByDeptName(String name);

    //通过医生获取其科室以及挂号等级

}
