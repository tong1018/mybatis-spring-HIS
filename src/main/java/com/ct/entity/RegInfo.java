package com.ct.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.sql.Date;

public class RegInfo {
    private int id;
    private int medRecID;
    private int deptID;
    private int docID;
    private int regLevelID;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date regTime;
    private int operatorID;
    private int status;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date diagTime;
    private String noonType;
    private int isNeedBook;
    private BigDecimal regFee;

    public RegInfo() {
    }

    public RegInfo(int id, int medRecID, int deptID, int docID, int regLevelID, Date regTime, int operatorID, int status, Date diagTime, String noonType, int isNeedBook, BigDecimal regFee) {
        this.id = id;
        this.medRecID = medRecID;
        this.deptID = deptID;
        this.docID = docID;
        this.regLevelID = regLevelID;
        this.regTime = regTime;
        this.operatorID = operatorID;
        this.status = status;
        this.diagTime = diagTime;
        this.noonType = noonType;
        this.isNeedBook = isNeedBook;
        this.regFee = regFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedRecID() {
        return medRecID;
    }

    public void setMedRecID(int medRecID) {
        this.medRecID = medRecID;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public int getRegLevelID() {
        return regLevelID;
    }

    public void setRegLevelID(int regLevelID) {
        this.regLevelID = regLevelID;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public int getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getDiagTime() {
        return diagTime;
    }

    public void setDiagTime(Date diagTime) {
        this.diagTime = diagTime;
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

    public BigDecimal getRegFee() {
        return regFee;
    }

    public void setRegFee(BigDecimal regFee) {
        this.regFee = regFee;
    }

    @Override
    public String toString() {
        return "RegInfo{" +
                "id=" + id +
                ", medRecID=" + medRecID +
                ", deptID=" + deptID +
                ", docID=" + docID +
                ", regLevelID=" + regLevelID +
                ", regTime=" + regTime +
                ", operatorID=" + operatorID +
                ", status=" + status +
                ", diagTime=" + diagTime +
                ", noonType='" + noonType + '\'' +
                ", isNeedBook=" + isNeedBook +
                ", regFee=" + regFee +
                '}';
    }
}
