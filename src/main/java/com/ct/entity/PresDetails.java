package com.ct.entity;

public class PresDetails {
    private int id;
    private int patientpreID;
    private int drugID;
    private String useWay;
    private String dosage;
    private String frequency;
    private int number;
    private String status;
    private int type;

    public PresDetails() {
    }

    public PresDetails(int id, int patientpreID, int drugID, String useWay, String dosage, String frequency, int number, String status, int type) {
        this.id = id;
        this.patientpreID = patientpreID;
        this.drugID = drugID;
        this.useWay = useWay;
        this.dosage = dosage;
        this.frequency = frequency;
        this.number = number;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientpreID() {
        return patientpreID;
    }

    public void setPatientpreID(int patientpreID) {
        this.patientpreID = patientpreID;
    }

    public int getDrugID() {
        return drugID;
    }

    public void setDrugID(int drugID) {
        this.drugID = drugID;
    }

    public String getUseWay() {
        return useWay;
    }

    public void setUseWay(String useWay) {
        this.useWay = useWay;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
