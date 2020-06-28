package com.mk.business.buyitem.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @date: 2020-5-13 19:31
 * @author: Znw · Smile
 * @Description: 待校验实体参数
 */
public class BuyitemCheckoutParam implements Serializable {
    private static final long serialVersionUID = 7410666951210047290L;
    private String buyitemCode;
    private String regionGuid;
    private Short year;
    private String orgGuid;
    private String origin;
    private BigDecimal confirmMoney;
    private BigDecimal buyitemMoney;
    private Integer bizValid;
    private String interfaceCode;
    private String dataResource;

    public String getBuyitemCode() {
        return buyitemCode;
    }

    public void setBuyitemCode(String buyitemCode) {
        this.buyitemCode = buyitemCode;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public BigDecimal getConfirmMoney() {
        return confirmMoney;
    }

    public void setConfirmMoney(BigDecimal confirmMoney) {
        this.confirmMoney = confirmMoney;
    }

    public BigDecimal getBuyitemMoney() {
        return buyitemMoney;
    }

    public void setBuyitemMoney(BigDecimal buyitemMoney) {
        this.buyitemMoney = buyitemMoney;
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
