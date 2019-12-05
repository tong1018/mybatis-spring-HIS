package com.ct.entity;

public class HrHomePage {
    private int id;
    private int MRID;
    private int docID;
    private int regID;
    private String chiefComplaint;
    private String presentIllness;
    private String presentTreatment;
    private String pastHistory;
    private String allergyHistory;
    private String physicalExam;
    private String advice;
    private String attention;
    private String testResult;
    private String diagResult;
    private String dealAdvice;
    private int MRStatus;

    public HrHomePage(int id,int docID,int MRID, int regID, String chiefComplaint, String presentIllness, String presentTreatment, String pastHistory, String allergyHistory, String physicalExam, String advice, String attention, String testResult, String diagResult, String dealAdvice, int MRStatus) {
        this.MRID = MRID;
        this.docID = docID;
        this.id = id;
        this.regID = regID;
        this.chiefComplaint = chiefComplaint;
        this.presentIllness = presentIllness;
        this.presentTreatment = presentTreatment;
        this.pastHistory = pastHistory;
        this.allergyHistory = allergyHistory;
        this.physicalExam = physicalExam;
        this.advice = advice;
        this.attention = attention;
        this.testResult = testResult;
        this.diagResult = diagResult;
        this.dealAdvice = dealAdvice;
        this.MRStatus = MRStatus;
    }

    public HrHomePage() {
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMRID() {
        return MRID;
    }

    public void setMRID(int MRID) {
        this.MRID = MRID;
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

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getDiagResult() {
        return diagResult;
    }

    public void setDiagResult(String diagResult) {
        this.diagResult = diagResult;
    }

    public String getDealAdvice() {
        return dealAdvice;
    }

    public void setDealAdvice(String dealAdvice) {
        this.dealAdvice = dealAdvice;
    }

    public int getMRStatus() {
        return MRStatus;
    }

    public void setMRStatus(int MRStatus) {
        this.MRStatus = MRStatus;
    }
}
