package com.ct.service.inf;

import com.ct.entity.Charges;
import com.ct.entity.HisUser;
import com.ct.entity.Invoice;
import com.ct.model.ChargeModel;
import com.ct.model.PayModel;

import java.math.BigDecimal;
import java.util.List;

public interface ChargeInterface {

    //添加新的费用记录
    public Charges addCharge(ChargeModel chargeModel, HisUser user);

    public List<Object> getCharges(int medRecID);

    public String getCountPrice(int medRecID);

    public Invoice addInvoice(int operatorID, BigDecimal account, int invoiceCode, int medRecID);

    public void payCharge(PayModel payModel, int operatorID);

}
