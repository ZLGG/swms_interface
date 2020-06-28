package com.mk.business.project.model;

import java.math.BigDecimal;

public class BidItem {
    private String bidItemGuid;
    private String projectGuid;
    private String orgGuid;
    private String bidItemNo;
    private String bidItemName;
    private String bidItemMoney;
    private String requirement;
    private Integer purMethod;
    private BigDecimal priceDiscount;
    private String interfaceCode;
    private String dataResource;
    private BigDecimal depositMoney;

    public BigDecimal getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(BigDecimal priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public String getBidItemGuid() {
        return bidItemGuid;
    }

    public void setBidItemGuid(String bidItemGuid) {
        this.bidItemGuid = bidItemGuid;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getOrgGuid() {
        return orgGuid;
    }

    public void setOrgGuid(String orgGuid) {
        this.orgGuid = orgGuid;
    }

    public String getBidItemNo() {
        return bidItemNo;
    }

    public void setBidItemNo(String bidItemNo) {
        this.bidItemNo = bidItemNo;
    }

    public String getBidItemName() {
        return bidItemName;
    }

    public void setBidItemName(String bidItemName) {
        this.bidItemName = bidItemName;
    }

    public String getBidItemMoney() {
        return bidItemMoney;
    }

    public void setBidItemMoney(String bidItemMoney) {
        this.bidItemMoney = bidItemMoney;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Integer getPurMethod() {
        return purMethod;
    }

    public void setPurMethod(Integer purMethod) {
        this.purMethod = purMethod;
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

    public BigDecimal getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(BigDecimal depositMoney) {
        this.depositMoney = depositMoney;
    }
}
