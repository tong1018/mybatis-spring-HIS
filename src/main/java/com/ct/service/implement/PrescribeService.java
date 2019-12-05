package com.ct.service.implement;

import com.ct.entity.PresDetails;
import com.ct.entity.Prescribe;
import com.ct.exception.ResultException;
import com.ct.mapper.PrescribeMapper;
import com.ct.model.PresDetailsModel;
import com.ct.model.PrescribeModel;
import com.ct.result.ResultCode;
import com.ct.service.inf.PrescribeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PrescribeService implements PrescribeInterface {
    @Autowired
    private PrescribeMapper prescribeMapper;

    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    java.sql.Date DateSql = java.sql.Date.valueOf(date.format(formatter));

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public List<Object> getAllDrugs(){
        return prescribeMapper.getAllDrugs();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public List<Object> getPrescribe(int regID){
        return prescribeMapper.getPrescribe(regID);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public Prescribe addPrescribe(PrescribeModel prescribeModel,int docID){
        Prescribe prescribe = new Prescribe();
        prescribe.setmrid(prescribeModel.getmrID());
        prescribe.setOpenDocID(docID);
        prescribe.setRegID(prescribeModel.getRegID());
        prescribe.setPreName(prescribeModel.getPreName());
        prescribe.setType(prescribeModel.getType());
        prescribe.setOpenTime(DateSql);
        prescribe.setStatus("暂存");
        //prescribeMapper.addPrescription(prescribe);
        try{
            prescribeMapper.addPrescription(prescribe);
        }catch (Exception e){
            throw  new ResultException(ResultCode.INSERT_FAIL);
        }

        return prescribe;

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public void delPrescribe(int pre){
       // prescribeMapper.delPrescribe(pre);

        try{
            prescribeMapper.delPrescribe(pre);
            //prescribeMapper.changePreDetailStatus(pre,"已删除");
        }catch (Exception e){
            throw  new ResultException(ResultCode.DEL_FAIL);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public void subPrescribe(int pre){
        try{
            prescribeMapper.subPrescribe(pre);
            prescribeMapper.changePreDetailStatus(pre,"已开立");
        }catch (Exception e){
            throw  new ResultException(ResultCode.DEL_FAIL);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public void trashPrescribe(int pre){
        try{
            prescribeMapper.trashPrescribe(pre);
            prescribeMapper.changePreDetailStatus(pre,"已作废");
        }catch (Exception e){
            throw  new ResultException(ResultCode.DEL_FAIL);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public List<Object> getPrescribeDetails(int presID){
        List<Object> presdetails = prescribeMapper.getPrescribeDetails(presID);
        return presdetails;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public PresDetails addPreDetails(PresDetailsModel prescribeModel){
        //prescribeMapper.addPrescription(prescribe);
       PresDetails presDetails = new PresDetails();
       presDetails.setDosage(prescribeModel.getDosage());
       presDetails.setDrugID(prescribeModel.getDrugID());
       presDetails.setFrequency(prescribeModel.getFrequency());
       presDetails.setNumber(prescribeModel.getNumber());
       presDetails.setPatientpreID(prescribeModel.getPatientpreID());
       presDetails.setUseWay(prescribeModel.getUseWay());
       presDetails.setStatus("暂存");
       presDetails.setType(prescribeModel.getType());

       prescribeMapper.addPreDetails(presDetails);

       return presDetails;

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public void updatePresDetailStatus(int predetailID,String status){
        prescribeMapper.changePreDetailStatus(predetailID,status);
    }


}
