package com.project.healingEars.http.vo;

import com.google.gson.annotations.SerializedName;

public class ProductDetailVO {

    @SerializedName("proDetailNumber")
    private Long proDetailId;

    @SerializedName("proDetailNumber")
    private String proDetailNumber;

    @SerializedName("proDetailQR")
    private String proDetailQR;

    @SerializedName("proDetailDate")
    private String proDetailDate;

    @SerializedName("proDetailRentCheck")
    private boolean proDetailRentCheck;
    /*
    @SerializedName("productList")
    private ProductListVO productList;

    @SerializedName("productList")
    private StationListVO stationList;
    */
    public ProductDetailVO() { System.out.println("ProductDetail 생성자 호출"); }

    public Long getProDetailId() {
        return proDetailId;
    }

    public void setProDetailId(Long proDetailId) {
        this.proDetailId = proDetailId;
    }

    public String getProDetailNumber() {
        return proDetailNumber;
    }

    public void setProDetailNumber(String proDetailNumber) {
        this.proDetailNumber = proDetailNumber;
    }

    public String getProDetailQR() {
        return proDetailQR;
    }

    public void setProDetailQR(String proDetailQR) {
        this.proDetailQR = proDetailQR;
    }

    public String getProDetailDate() {
        return proDetailDate;
    }

    public void setProDetailDate(String proDetailDate) {
        this.proDetailDate = proDetailDate;
    }

    public boolean isProDetailRentCheck() {
        return proDetailRentCheck;
    }

    public void setProDetailRentCheck(boolean proDetailRentCheck) {
        this.proDetailRentCheck = proDetailRentCheck;
    }

    @Override
    public String toString() {
        return "ProductDetailVO{" +
                "proDetailId=" + proDetailId +
                ", proDetailNumber='" + proDetailNumber + '\'' +
                ", proDetailQR='" + proDetailQR + '\'' +
                ", proDetailDate='" + proDetailDate + '\'' +
                //", productList=" + productList +
                //", stationList=" + stationList +
                '}';
    }
}
