package com.ct.model;

import java.util.List;

public class PayModel {
    private List<Integer> list;
    private int inVoiceID;

    public PayModel(List<Integer> list,int inVoiceID) {
        this.list = list;
        this.inVoiceID = inVoiceID;
    }

    public PayModel() {
    }

    public int getInVoiceID() {
        return inVoiceID;
    }

    public void setInVoiceID(int inVoiceID) {
        this.inVoiceID = inVoiceID;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
