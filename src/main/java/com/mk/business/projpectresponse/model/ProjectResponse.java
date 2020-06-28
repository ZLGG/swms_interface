package com.mk.business.projpectresponse.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProjectResponse {
    private String responseGuid;
    private String projectGuid;
    private String bidItemGuid;
    private String supplierName;
    private String isUnion;
    private String trusteeName;
    private String mobile;
    private String isDisable;
    private String disableReason;
    private String locationGuid;
    private Integer supplierSize;
    private Integer supplierFeatures;
    private BigDecimal priceDiscount;
    private String depositPayAccountName;
    private String depositPayAccount;
    private Date depositPayTime;
    private BigDecimal depositPayMoney;
    private String interfaceCode;
    private String dataResource;

    private List<BidSupplierInfo> bidSupplierInfoList;

    public List<BidSupplierInfo> getBidSupplierInfoList() {
        return bidSupplierInfoList;
    }

    public void setBidSupplierInfoList(List<BidSupplierInfo> bidSupplierInfoList) {
        this.bidSupplierInfoList = bidSupplierInfoList;
    }

    public String getDepositPayAccountName() {
        return depositPayAccountName;
    }

    public void setDepositPayAccountName(String depositPayAccountName) {
        this.depositPayAccountName = depositPayAccountName;
    }

    public String getDepositPayAccount() {
        return depositPayAccount;
    }

    public void setDepositPayAccount(String depositPayAccount) {
        this.depositPayAccount = depositPayAccount;
    }

    public Date getDepositPayTime() {
        return depositPayTime;
    }

    public void setDepositPayTime(Date depositPayTime) {
        this.depositPayTime = depositPayTime;
    }

    public BigDecimal getDepositPayMoney() {
        return depositPayMoney;
    }

    public void setDepositPayMoney(BigDecimal depositPayMoney) {
        this.depositPayMoney = depositPayMoney;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getDataResource() {
        return dataResource;
    }

    public void setDataResource(String dataResource) {
        this.dataResource = dataResource;
    }


    public String getResponseGuid() {
        return responseGuid;
    }

    public void setResponseGuid(String responseGuid) {
        this.responseGuid = responseGuid;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getBidItemGuid() {
        return bidItemGuid;
    }

    public void setBidItemGuid(String bidItemGuid) {
        this.bidItemGuid = bidItemGuid;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getIsUnion() {
        return isUnion;
    }

    public void setIsUnion(String isUnion) {
        this.isUnion = isUnion;
    }

    public String getTrusteeName() {
        return trusteeName;
    }

    public void setTrusteeName(String trusteeName) {
        this.trusteeName = trusteeName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(String isDisable) {
        this.isDisable = isDisable;
    }

    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public String getLocationGuid() {
        return locationGuid;
    }

    public void setLocationGuid(String locationGuid) {
        this.locationGuid = locationGuid;
    }

    public Integer getSupplierSize() {
        return supplierSize;
    }

    public void setSupplierSize(Integer supplierSize) {
        this.supplierSize = supplierSize;
    }

    public Integer getSupplierFeatures() {
        return supplierFeatures;
    }

    public void setSupplierFeatures(Integer supplierFeatures) {
        this.supplierFeatures = supplierFeatures;
    }

    public BigDecimal getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(BigDecimal priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

}
