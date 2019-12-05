package com.ct.entity;

import java.sql.Date;

public class Prescribe {
    private int id;
    private int mrid;
    private int regID;
    private String preName;
    private int openDocID;
    private Date openTime;
    private int type;
    private String status;

    public Prescribe() {
    }

    public Prescribe(int id, int mrid, int regID, String preName, int openDocID, Date openTime, int type, String status) {
        this.id = id;
        this.mrid = mrid;
        this.regID = regID;
        this.preName = preName;
        this.openDocID = openDocID;
        this.openTime = openTime;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getmrid() {
        return mrid;
    }

    public void setmrid(int mrid) {
        this.mrid = mrid;
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

    public int getOpenDocID() {
        return openDocID;
    }

    public void setOpenDocID(int openDocID) {
        this.openDocID = openDocID;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
