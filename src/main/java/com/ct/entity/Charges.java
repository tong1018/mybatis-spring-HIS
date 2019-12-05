package com.ct.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.sql.Date;

public class Charges {
    private int id;
    @NotBlank
    private int regID;
    private int inVoiceID;
    private int prescriptionID;
    private int checkItemID;
    private int itemType;
    private String name;
    private BigDecimal price;
    private int number;
    private int deptID;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date setupTime;
    private int openerID;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date operationTime;
    private int operatorID;
    private int backFeeFlag;
    private String  status;
    private int medRecID;

    public Charges() {
    }

    public int getMedRecID() {
        return medRecID;
    }

    public void setMedRecID(int medRecID) {
        this.medRecID = medRecID;
    }

    public Charges(int medRecID, int id, String status, @NotBlank int regID, @NotBlank int inVoiceID, int prescriptionID, int checkItemID, int itemType, String name, BigDecimal price, int number, int deptID, Date setupTime, int openerID, Date operationTime, int operatorID, int backFeeFlag) {
        this.medRecID = medRecID;
        this.status =status;
        this.id = id;
        this.regID = regID;
        this.inVoiceID = inVoiceID;
        this.prescriptionID = prescriptionID;
        this.checkItemID = checkItemID;
        this.itemType = itemType;
        this.name = name;
        this.price = price;
        this.number = number;
        this.deptID = deptID;
        this.setupTime = setupTime;
        this.openerID = openerID;
        this.operationTime = operationTime;
        this.operatorID = operatorID;
        this.backFeeFlag = backFeeFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public int getInVoiceID() {
        return inVoiceID;
    }

    public void setInVoiceID(int inVoiceID) {
        this.inVoiceID = inVoiceID;
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public int getCheckItemID() {
        return checkItemID;
    }

    public void setCheckItemID(int checkItemID) {
        this.checkItemID = checkItemID;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(Date setupTime) {
        this.setupTime = setupTime;
    }

    public int getOpenerID() {
        return openerID;
    }

    public void setOpenerID(int openerID) {
        this.openerID = openerID;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public int getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }

    public int getBackFeeFlag() {
        return backFeeFlag;
    }

    public void setBackFeeFlag(int backFeeFlag) {
        this.backFeeFlag = backFeeFlag;
    }

    @Override
    public String toString() {
        return "Charges{" +
                "regID=" + regID +
                ", inVoiceID=" + inVoiceID +
                ", prescriptionID=" + prescriptionID +
                ", checkItemID=" + checkItemID +
                ", itemType=" + itemType +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", deptID=" + deptID +
                ", setupTime=" + setupTime +
                ", openerID=" + openerID +
                ", operationTime=" + operationTime +
                ", operatorID=" + operatorID +
                ", backFeeFlag=" + backFeeFlag +
                '}';
    }
}
