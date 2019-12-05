package com.ct.service.implement;

import com.ct.entity.HrHomePage;
import com.ct.mapper.ConsultMapper;
import com.ct.model.HrHomePageModel;
import com.ct.service.inf.ConsultInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class ConsultService implements ConsultInterface {
    @Autowired
    private ConsultMapper consultMapper;

    /**
     * 获取没有看诊的病人信息
     * @param docID
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public List<Object> getNonConsultPatients(int docID) {
        return consultMapper.getNonConsultPatients(docID);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public List<Object> getConsultedPatients(int docID) {
        return consultMapper.getConsultedPatients(docID);
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public HrHomePage addHrHomePage(HrHomePageModel hrHomePageModel,int docID){
        HrHomePage hrHomePage = new HrHomePage();
        hrHomePage.setMRID(hrHomePageModel.getMrID());
        hrHomePage.setAllergyHistory(hrHomePageModel.getAllergyHistory());
        hrHomePage.setChiefComplaint(hrHomePageModel.getChiefComplaint());
        hrHomePage.setMRStatus(1);
        hrHomePage.setPhysicalExam(hrHomePageModel.getPhysicalExam());
        hrHomePage.setPresentIllness(hrHomePageModel.getPresentIllness());
        hrHomePage.setPresentTreatment(hrHomePageModel.getPresentTreatment());
        hrHomePage.setRegID(hrHomePageModel.getRegID());
        hrHomePage.setDocID(docID);//后期修改

        consultMapper.addHrHomePage(hrHomePage);
//        try{
//            consultMapper.addHrHomePage(hrHomePage);
//        }catch (Exception e){
//            throw  new ResultException(ResultCode.INSERT_FAIL);
//        }

        return hrHomePage;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public void patientToConsulted(int regID){
        consultMapper.patientToConsulted(regID);
    }

}
