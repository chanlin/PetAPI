package com.chanlin.pet.model;

public class Breed {
    private Integer bId;

    private String bBreed;

    private Integer bPid;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbBreed() {
        return bBreed;
    }

    public void setbBreed(String bBreed) {
        this.bBreed = bBreed == null ? null : bBreed.trim();
    }

    public Integer getbPid() {
        return bPid;
    }

    public void setbPid(Integer bPid) {
        this.bPid = bPid;
    }
}