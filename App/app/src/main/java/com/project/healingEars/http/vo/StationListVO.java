package com.project.healingEars.http.vo;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class StationListVO {
    @SerializedName("stnId")
    private Long stnId;

    @SerializedName("stnName")
    private String stnName;

    @SerializedName("stnLocation")
    private String stnLocation;

    @SerializedName("stnImg")
    private String stnImg;

    @SerializedName("stnCreateTimestamp")
    private String stnCreateTimestamp;

    public StationListVO() {
        System.out.println("stationVO 생성자 호출");
    }

    public Long getStnId() {
        return stnId;
    }

    public void setStnId(Long stnId) {
        this.stnId = stnId;
    }

    public String getStnName() {
        return stnName;
    }

    public void setStnName(String stnName) {
        this.stnName = stnName;
    }

    public String getStnLocation() {
        return stnLocation;
    }

    public void setStnLocation(String stnLocation) {
        this.stnLocation = stnLocation;
    }

    public String getStnImg() {
        return stnImg;
    }

    public void setStnImg(String stnImg) {
        this.stnImg = stnImg;
    }

    public String getStnCreateTimestamp() {
        return stnCreateTimestamp;
    }

    public void setStnCreateTimestamp(String stnCreateTimestamp) {
        this.stnCreateTimestamp = stnCreateTimestamp;
    }
}
