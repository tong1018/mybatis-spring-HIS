package com.ct.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.sql.Date;

public class Drugs {
    private int id;
    private String drugCode;
    private String dosage;
    private String type;
    private String name;
    private String format;
    private String unit;
    private String  manufacter;
    private int dosageID;
    private int typeID;
    private BigDecimal price;
    private String CODE;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date setupTime;

    public Drugs() {
    }

    public Drugs(String dosage,String type,int id, String drugCode, String name, String format, String unit, String manufacter, int dosageID, int typeID, BigDecimal price, String CODE, Date setupTime) {
        this.dosage =dosage;
        this.type = type;
        this.id = id;
        this.drugCode = drugCode;
        this.name = name;
        this.format = format;
        this.unit = unit;
        this.manufacter = manufacter;
        this.dosageID = dosageID;
        this.typeID = typeID;
        this.price = price;
        this.CODE = CODE;
        this.setupTime = setupTime;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacter() {
        return manufacter;
    }

    public void setManufacter(String manufacter) {
        this.manufacter = manufacter;
    }

    public int getDosageID() {
        return dosageID;
    }

    public void setDosageID(int dosageID) {
        this.dosageID = dosageID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public Date getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(Date setupTime) {
        this.setupTime = setupTime;
    }
}
