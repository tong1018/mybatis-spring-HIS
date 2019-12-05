package com.ct.model;


public class HrHomePageModel {

    private int mrID;
    private int regID;
    private String chiefComplaint;
    private String presentIllness;
    private String presentTreatment;
    private String pastHistory;
    private String allergyHistory;
    private String physicalExam;

    public HrHomePageModel(int mrID, int regID, String chiefComplaint, String presentIllness, String presentTreatment, String pastHistory, String allergyHistory, String physicalExam) {
        this.mrID = mrID;
        this.regID = regID;
        this.chiefComplaint = chiefComplaint;
        this.presentIllness = presentIllness;
        this.presentTreatment = presentTreatment;
        this.pastHistory = pastHistory;
        this.allergyHistory = allergyHistory;
        this.physicalExam = physicalExam;
    }

    public HrHomePageModel() {
    }

    public int getMrID() {
        return mrID;
    }

    public void setMrID(int mrID) {
        this.mrID = mrID;
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public String getPresentIllness() {
        return presentIllness;
    }

    public void setPresentIllness(String presentIllness) {
        this.presentIllness = presentIllness;
    }

    public String getPresentTreatment() {
        return presentTreatment;
    }

    public void setPresentTreatment(String presentTreatment) {
        this.presentTreatment = presentTreatment;
    }

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory;
    }

    public String getAllergyHistory() {
        return allergyHistory;
    }

    public void setAllergyHistory(String allergyHistory) {
        this.allergyHistory = allergyHistory;
    }

    public String getPhysicalExam() {
        return physicalExam;
    }

    public void setPhysicalExam(String physicalExam) {
        this.physicalExam = physicalExam;
    }
}
