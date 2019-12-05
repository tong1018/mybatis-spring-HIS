package com.ct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HisUser {
    private int id;
    private String username;
    private String password;
    private String name;
    private int userType;
    private int docTitleID;
    private int isDuty;
    private int deptID;
    private int regLevelID;
    private int deleFlag;

    public HisUser() {
    }

    public HisUser(int id, String username, String password, String name, int userType, int docTitleID, int isDuty, int deptID, int regLevelID, int deleFlag) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.userType = userType;
        this.docTitleID = docTitleID;
        this.isDuty = isDuty;
        this.deptID = deptID;
        this.regLevelID = regLevelID;
        this.deleFlag = deleFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getDocTitleID() {
        return docTitleID;
    }

    public void setDocTitleID(int docTitleID) {
        this.docTitleID = docTitleID;
    }

    public int getIsDuty() {
        return isDuty;
    }

    public void setIsDuty(int isDuty) {
        this.isDuty = isDuty;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public int getRegLevelID() {
        return regLevelID;
    }

    public void setRegLevelID(int regLevelID) {
        this.regLevelID = regLevelID;
    }

    public int getDeleFlag() {
        return deleFlag;
    }

    public void setDeleFlag(int deleFlag) {
        this.deleFlag = deleFlag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "HisUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", userType=" + userType +
                ", docTitleID=" + docTitleID +
                ", isDuty=" + isDuty +
                ", deptID=" + deptID +
                ", regLevelID=" + regLevelID +
                ", deleFlag=" + deleFlag +
                '}';
    }
}
