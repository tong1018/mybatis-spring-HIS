package com.ct.service.inf;

import com.ct.entity.HrHomePage;
import com.ct.model.HrHomePageModel;

import java.util.List;

public interface ConsultInterface {

    //获取医生当天未完毕的患者
    public List<Object> getNonConsultPatients(int docID);

    //获取医生当天就诊完毕的患者
    public List<Object> getConsultedPatients(int docID);

    //添加病历首页
    public HrHomePage addHrHomePage(HrHomePageModel hrHomePageModel,int docID);

    public void patientToConsulted(int regID);




}
