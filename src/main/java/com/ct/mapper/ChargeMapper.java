package com.ct.mapper;

import com.ct.entity.Charges;
import com.ct.entity.Invoice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargeMapper {
    /**
     * 添加新的发票
     * **/
    public int addInvoice(Invoice invoice);

    /**
     * 添加缴费明细
     * **/
    public int addCharges(Charges charges);

    //获取用户
    public List<Object> getPatientAllCharges(int medRecID);

    //获取缴费金额
    public String countPrice(int medRecID);

    public void updateCharge(@Param("chargeID")int chargeID,@Param("operatorID")int operatorID,@Param("inVoiceID")int inVoiceID,@Param("status")String status);

}
