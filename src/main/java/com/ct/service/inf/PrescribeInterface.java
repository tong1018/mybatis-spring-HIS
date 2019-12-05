package com.ct.service.inf;

import com.ct.entity.PresDetails;
import com.ct.entity.Prescribe;
import com.ct.model.PresDetailsModel;
import com.ct.model.PrescribeModel;

import java.util.List;

public interface PrescribeInterface {
    //获取所有药品信息
    public List<Object> getAllDrugs();

    //获取患者处方
    public List<Object> getPrescribe(int regID);

    //添加处方
    public Prescribe addPrescribe(PrescribeModel prescribe, int docID);

    //删除处方
    public void delPrescribe(int pre);

    //开立
    public void subPrescribe(int pre);

    //废除
    public void trashPrescribe(int pre);

    //获取患者处方明细
    public List<Object> getPrescribeDetails(int presID);

    //添加处方明细
    public PresDetails addPreDetails(PresDetailsModel presDetails);

    //通过更新
    public void updatePresDetailStatus(int predetailID,String status);




}
