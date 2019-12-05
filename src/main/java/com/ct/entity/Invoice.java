package com.ct.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.sql.Date;

public class Invoice {
    private int id;
    private int invoiceCode;
    private BigDecimal account;
    private int status;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date operationTime;
    private int operatorID;
    private int medRecID;
    private int backInvoiceCode;
    private int checkStatus;

    public Invoice() {
    }

    public Invoice(int id,int invoiceCode, BigDecimal account, int status, Date operationTime, int operatorID, int regID, int backInvoiceCode, int checkStatus) {
        this.id = id;
        this.invoiceCode = invoiceCode;
        this.account = account;
        this.status = status;
        this.operationTime = operationTime;
        this.operatorID = operatorID;
        this.medRecID = regID;
        this.backInvoiceCode = backInvoiceCode;
        this.checkStatus = checkStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(int invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getMedRecID() {
        return medRecID;
    }

    public void setMedRecID(int regID) {
        this.medRecID = regID;
    }

    public int getBackInvoiceCode() {
        return backInvoiceCode;
    }

    public void setBackInvoiceCode(int backInvoiceCode) {
        this.backInvoiceCode = backInvoiceCode;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceCode=" + invoiceCode +
                ", account=" + account +
                ", status=" + status +
                ", operationTime=" + operationTime +
                ", operatorID=" + operatorID +
                ", medRecID=" + medRecID +
                ", backInvoiceCode=" + backInvoiceCode +
                ", checkStatus=" + checkStatus +
                '}';
    }
}
