package com.ct.service.implement;

import com.ct.entity.Charges;
import com.ct.entity.HisUser;
import com.ct.entity.Invoice;
import com.ct.mapper.ChargeMapper;
import com.ct.model.ChargeModel;
import com.ct.model.PayModel;
import com.ct.service.inf.ChargeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ChargeService implements ChargeInterface {
    @Autowired
    private ChargeMapper chargeMapper;

    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    java.sql.Date DateSql = java.sql.Date.valueOf(date.format(formatter));


    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public Charges addCharge(ChargeModel chargeModel, HisUser user){
        Charges charges = new Charges();
        charges.setBackFeeFlag(0);
        charges.setDeptID(user.getDeptID());
        charges.setItemType(chargeModel.getItemType());
        charges.setName(chargeModel.getName());
        charges.setNumber(chargeModel.getNumber());
        charges.setOpenerID(user.getId());
        charges.setPrice(chargeModel.getPrice());
        charges.setPrescriptionID(chargeModel.getPrescriptionID());
        charges.setSetupTime(DateSql);
        charges.setRegID(chargeModel.getRegID());
        charges.setStatus("已开立");
        charges.setMedRecID(chargeModel.getMedRecID());
        chargeMapper.addCharges(charges);
//        try{
//
//        }catch (Exception e){
//            throw  new ResultException(ResultCode.INSERT_FAIL);
//        }


        return charges;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public List<Object> getCharges(int medRecID){
        return chargeMapper.getPatientAllCharges(medRecID);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public String getCountPrice(int medRecID){
        String count = chargeMapper.countPrice(medRecID);
        int i = 0;
        return count;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public Invoice addInvoice(int operatorID,BigDecimal account,int invoiceCode,int medRecID){
        Invoice invoice = new Invoice();
        invoice.setOperationTime(DateSql);
        invoice.setStatus(1);
        invoice.setAccount(account);
        invoice.setCheckStatus(0);
        invoice.setInvoiceCode(invoiceCode);
        invoice.setMedRecID(medRecID);
        invoice.setOperatorID(operatorID);

        chargeMapper.addInvoice(invoice);
        return invoice;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public void payCharge(PayModel payModel,int operatorID){
        for(int chargeID:payModel.getList()){
            chargeMapper.updateCharge(chargeID,operatorID,payModel.getInVoiceID(),"已缴费");
        }

    }



}
