package com.ct.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class Patient {
    private String name;

    private int medRecID;
    private int sex;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthDate;
    private int age;
    private String address;
    private String identityID;

    public Patient(String name, int medRecID, int sex, Date birthDate, String address, String identityID,int age) {
        this.name = name;
        this.medRecID = medRecID;
        this.sex = sex;
        this.birthDate = birthDate;
        this.address = address;
        this.identityID = identityID;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Patient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMedRecID() {
        return medRecID;
    }

    public void setMedRecID(int medRecID) {
        this.medRecID = medRecID;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
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
        return "Patient{" +
                "name='" + name + '\'' +
                ", medRecID=" + medRecID +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", identityID='" + identityID + '\'' +
                '}';
    }
}
