package com.ct.model;

public class InvoiceModel {
    private int InvoiceCode;
    private int isNeedBook;
    private int regLevelID;
    private int operatorID;
    private int medRecID;

    public InvoiceModel() {
    }

    public InvoiceModel(int invoiceCode, int isNeedBook, int regLevelID, int operatorID, int medRecID) {
        InvoiceCode = invoiceCode;
        this.isNeedBook = isNeedBook;
        this.regLevelID = regLevelID;
        this.operatorID = operatorID;
        this.medRecID = medRecID;
    }

    public int getInvoiceCode() {
        return InvoiceCode;
    }

    public void setInvoiceCode(int invoiceCode) {
        InvoiceCode = invoiceCode;
    }

    public int getIsNeedBook() {
        return isNeedBook;
    }

    public void setIsNeedBook(int isNeedBook) {
        this.isNeedBook = isNeedBook;
    }

    public int getRegLevelID() {
        return this.regLevelID;
    }

    public void setRegLevelID(int regLevelID) {
        this.regLevelID = regLevelID;
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

    @Override
    public String toString() {
        return "InvoiceModel{" +
                "InvoiceCode=" + InvoiceCode +
                ", isNeedBook=" + isNeedBook +
                ", regLevel=" + regLevelID +
                ", operatorID=" + operatorID +
                ", medRecID=" + medRecID +
                '}';
    }
}
