package com.chanlin.pet.model;

public class Pet {
    private Integer pId;

    private String pName;

    private String pSex;

    private Float pAge;

    private Integer pBid;

    private Float pLongitude;

    private Float pLatitude;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpSex() {
        return pSex;
    }

    public void setpSex(String pSex) {
        this.pSex = pSex == null ? null : pSex.trim();
    }

    public Float getpAge() {
        return pAge;
    }

    public void setpAge(Float pAge) {
        this.pAge = pAge;
    }

    public Integer getpBid() {
        return pBid;
    }

    public void setpBid(Integer pBid) {
        this.pBid = pBid;
    }

    public Float getpLongitude() {
        return pLongitude;
    }

    public void setpLongitude(Float pLongitude) {
        this.pLongitude = pLongitude;
    }

    public Float getpLatitude() {
        return pLatitude;
    }

    public void setpLatitude(Float pLatitude) {
        this.pLatitude = pLatitude;
    }
}