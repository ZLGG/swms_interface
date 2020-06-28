package com.mk.business.contract.param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @date: 2020-5-14 14:42
 * @author: Znw · Smile
 * @Description:合同待校验参数
 */
public class ContractCheckoutParam implements Serializable {
    private static final long serialVersionUID = 3031996146062235230L;
    private String contractState;
    private String contractCode;
    private String regionGuid;
    private Short year;
    private String orgGuid;
    private String financeDeptGuid;
    private String buyplanGuid;
    private BigDecimal buyplanMoney;
    private String kind;
    private String purcatalogType;
    private String platformTypeGuid;
    private String platformGuid;
    private Short isDirectBuy;
    private BigDecimal totalMoney;
    private Date signDate;
    private Date startDate;
    private Long bizValid;
    private String interfaceCode;
    private String dataResource;
    private Integer contractCreateType;

    public String getContractState() {
        return contractState;
    }

    public void setContractState(String contractState) {
        this.contractState = contractState;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getRegionGuid() {
        return regionGuid;
    }

    public void setRegionGuid(String regionGuid) {
        this.regionGuid = regionGuid;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public String getOrgGuid() {
        return orgGuid;
    }

    public void setOrgGuid(String orgGuid) {
        this.orgGuid = orgGuid;
    }

    public String getFinanceDeptGuid() {
        return financeDeptGuid;
    }

    public void setFinanceDeptGuid(String financeDeptGuid) {
        this.financeDeptGuid = financeDeptGuid;
    }

    public String getBuyplanGuid() {
        return buyplanGuid;
    }

    public void setBuyplanGuid(String buyplanGuid) {
        this.buyplanGuid = buyplanGuid;
    }

    public BigDecimal getBuyplanMoney() {
        return buyplanMoney;
    }

    public void setBuyplanMoney(BigDecimal buyplanMoney) {
        this.buyplanMoney = buyplanMoney;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPurcatalogType() {
        return purcatalogType;
    }

    public void setPurcatalogType(String purcatalogType) {
        this.purcatalogType = purcatalogType;
    }

    public String getPlatformTypeGuid() {
        return platformTypeGuid;
    }

    public void setPlatformTypeGuid(String platformTypeGuid) {
        this.platformTypeGuid = platformTypeGuid;
    }

    public String getPlatformGuid() {
        return platformGuid;
    }

    public void setPlatformGuid(String platformGuid) {
        this.platformGuid = platformGuid;
    }

    public Short getIsDirectBuy() {
        return isDirectBuy;
    }

    public void setIsDirectBuy(Short isDirectBuy) {
        this.isDirectBuy = isDirectBuy;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getBizValid() {
        return bizValid;
    }

    public void setBizValid(Long bizValid) {
        this.bizValid = bizValid;
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

    public Integer getContractCreateType() {
        return contractCreateType;
    }

    public void setContractCreateType(Integer contractCreateType) {
        this.contractCreateType = contractCreateType;
    }
}
