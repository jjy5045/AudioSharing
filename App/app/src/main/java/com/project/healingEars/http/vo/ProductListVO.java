package com.project.healingEars.http.vo;

import com.google.gson.annotations.SerializedName;

public class ProductListVO {
    @SerializedName("proListId")
    private Long proListId;

    @SerializedName("proListType")
    private String proListType;

    @SerializedName("proListName")
    private String proListName;

    @SerializedName("proListCompany")
    private String proListCompany;

    @SerializedName("proListText")
    private String proListText;

    @SerializedName("proListPrice")
    private String proListPrice;

    @SerializedName("proLIstRentPrice")
    private String proListRentPrice;

    public ProductListVO() { System.out.println("productDetail 생성자 호출"); }

    public Long getProListId() {
        return proListId;
    }

    public void setProListId(Long proListId) {
        this.proListId = proListId;
    }

    public String getProListType() {
        return proListType;
    }

    public void setProListType(String proListType) {
        this.proListType = proListType;
    }

    public String getProListName() {
        return proListName;
    }

    public void setProListName(String proListName) {
        this.proListName = proListName;
    }

    public String getProListCompany() {
        return proListCompany;
    }

    public void setProListCompany(String proListCompany) {
        this.proListCompany = proListCompany;
    }

    public String getProListText() {
        return proListText;
    }

    public void setProListText(String proListText) {
        this.proListText = proListText;
    }

    public String getProListPrice() {
        return proListPrice;
    }

    public void setProListPrice(String proListPrice) {
        this.proListPrice = proListPrice;
    }

    public String getProListRentPrice() {
        return proListRentPrice;
    }

    public void setProListRentPrice(String proListRentPrice) {
        this.proListRentPrice = proListRentPrice;
    }
}
