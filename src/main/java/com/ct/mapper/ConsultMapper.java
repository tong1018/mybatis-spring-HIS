package com.ct.mapper;

import com.ct.entity.HrHomePage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultMapper {
    //获取医生当天未完毕的患者
    public List<Object> getNonConsultPatients(int docID);

    //获取医生当天就诊完毕的患者
    public List<Object> getConsultedPatients(int docID);

    //添加病历首页信息
    public int addHrHomePage(HrHomePage hrHomePageModel);

    public int changeHomePage(HrHomePage hrHomePage);

    public void patientToConsulted(int regID);
}
