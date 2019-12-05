package com.ct.mapper;

import com.ct.entity.PresDetails;
import com.ct.entity.Prescribe;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescribeMapper {

    //获取所有的药品
    public List<Object> getAllDrugs();
    //获取患者处方
    public List<Object> getPrescribe(int regID);
    //获取常量名
    public Object getRealName(@Param("dosageID") int dosageID, @Param("typeID") int typeID);
    //删除处方
    public void delPrescribe(int presID);
    //添加处方
    public void addPrescription(Prescribe prescribe);
    //获取患者处方明细
    public List<Object> getPrescribeDetails(int presID);
    //开立
    public void subPrescribe( int id);
    //废除
    public void trashPrescribe(int id);
    //修改状态
    public void changePreDetailStatus(@Param("id") int id,@Param("status")String status);
    //添加药品
    public void addPreDetails(PresDetails presDetails);

    public void delPreDetailStatus(@Param("id") int id,@Param("status")String status);

}
