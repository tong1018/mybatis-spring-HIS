package com.ct.model;

public class PrescribeModel {
    private int mrID;
    private int regID;
    //private int openDocID;
    private String preName;
    private int type;

    public PrescribeModel() {
    }

    public PrescribeModel(int mrID, int regID, String preName, int type) {
        this.mrID = mrID;
        this.regID = regID;
        this.preName = preName;
        this.type = type;
    }

    public int getmrID() {
        return mrID;
    }

    public void setmrID(int mrID) {
        this.mrID = mrID;
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public String getPreName() {
        return preName;
    }

    public void setPreName(String preName) {
        this.preName = preName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
