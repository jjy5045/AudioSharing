package com.project.healingEars.http.vo;

public class ProductRentVO {
    private Long proDetailId;

    private String proDetailNumber;

    private String proDetailQR;

    private String proDetailDate;

    private boolean proDetailRentCheck;

    private ProductListVO productList;

    private StationListVO stationList;

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

    public ProductListVO getProductList() {
        return productList;
    }

    public void setProductList(ProductListVO productList) {
        this.productList = productList;
    }

    public StationListVO getStationList() {
        return stationList;
    }

    public void setStationList(StationListVO stationList) {
        this.stationList = stationList;
    }
}
