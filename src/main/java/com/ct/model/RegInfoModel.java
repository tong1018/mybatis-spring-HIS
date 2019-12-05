package com.ct.model;

import java.sql.Date;

public class RegInfoModel {

    //发票信息
    private int invoiceCode;
    //挂号信息
    private int docID;
    private int deptID;
    private int medRecID;
    private String noonType;
    private int isNeedBook;
    private Date diagTime;
    private int regLevelID;

    private int regID;
    //个人信息
    private String name;
    private int sex;
    private int age;
    private Date birthDate;
    private String address;
    private String identityID;

    public RegInfoModel() {
    }

    public int getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(int invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public int getMedRecID() {
        return medRecID;
    }

    public void setMedRecID(int medRecID) {
        this.medRecID = medRecID;
    }

    public String getNoonType() {
        return noonType;
    }

    public void setNoonType(String noonType) {
        this.noonType = noonType;
    }

    public int getIsNeedBook() {
        return isNeedBook;
    }

    public void setIsNeedBook(int isNeedBook) {
        this.isNeedBook = isNeedBook;
    }

    public Date getDiagTime() {
        return diagTime;
    }

    public void setDiagTime(Date diagTime) {
        this.diagTime = diagTime;
    }

    public int getRegLevelID() {
        return regLevelID;
    }

    public void setRegLevelID(int regLevelID) {
        this.regLevelID = regLevelID;
    }



    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentityID() {
        return identityID;
    }

    public void setIdentityID(String identityID) {
        this.identityID = identityID;
    }

    @Override
    public String toString() {
        return "RegInfoModel{" +
                "docID=" + docID +
                ", deptID=" + deptID +
                ", medRecID=" + medRecID +
                ", noonType='" + noonType + '\'' +
                ", isNeedBook=" + isNeedBook +
                ", diagTime=" + diagTime +
                ", regLevelID=" + regLevelID +

                ", regID=" + regID +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", identityID='" + identityID + '\'' +
                '}';
    }
}
