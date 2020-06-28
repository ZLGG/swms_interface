package com.mk.business.buyplan.param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @date: 2020-5-14 10:51
 * @author: Znw · Smile
 * @Description: 计划待校验参数
 */
public class BuyPlanCheckoutParam implements Serializable {
    private static final long serialVersionUID = -5038677227000661157L;
    private String buyplanCode;
    private String regionGuid;
    private Short year;
    private String orgGuid;
    private String financeDeptGuid;
    private String kind;
    private String purcatalogType;
    private String platformTypeGuid;
    private String platformGuid;
    private Short isDirectBuy;
    private BigDecimal buyplanMoney;
    private Date createDate;
    private Integer bizValid;
    private String interfaceCode;
    private String dataResource;

    public String getBuyplanCode() {
        return buyplanCode;
    }

    public void setBuyplanCode(String buyplanCode) {
        this.buyplanCode = buyplanCode;
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

    public BigDecimal getBuyplanMoney() {
        return buyplanMoney;
    }

    public void setBuyplanMoney(BigDecimal buyplanMoney) {
        this.buyplanMoney = buyplanMoney;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getBizValid() {
        return bizValid;
    }

    public void setBizValid(Integer bizValid) {
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
}
