package com.ct.model;

import java.math.BigDecimal;

public class ChargeModel {
    private int regID;
    private int prescriptionID;
    private int checkItemID;
    private int itemType;
    private String name;
    private BigDecimal price;
    private int number;
    private int medRecID;

    public ChargeModel() {
    }

    public ChargeModel(int medRecID,int regID, int prescriptionID, int checkItemID, int itemType, String name, BigDecimal price, int number) {
        this.regID = regID;
        this.prescriptionID = prescriptionID;
        this.checkItemID = checkItemID;
        this.itemType = itemType;
        this.name = name;
        this.price = price;
        this.number = number;
        this.medRecID = medRecID;
    }

    public int getMedRecID() {
        return medRecID;
    }

    public void setMedRecID(int medRecID) {
        this.medRecID = medRecID;
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
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

}
