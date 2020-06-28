package com.mk.business.buyitem.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @date: 2020-5-13 20:07
 * @author: Znw · Smile
 * @Description:
 */
public class BuyitemMoneyCheckoutParam implements Serializable {
    private static final long serialVersionUID = 2680840705110209409L;
    private String buyitemGuid;
    private String resourceGuid;
    private BigDecimal money;
    private Short valid;
    private String interfaceCode;
    private String dataResource;

    public String getBuyitemGuid() {
        return buyitemGuid;
    }

    public void setBuyitemGuid(String buyitemGuid) {
        this.buyitemGuid = buyitemGuid;
    }

    public String getResourceGuid() {
        return resourceGuid;
    }

    public void setResourceGuid(String resourceGuid) {
        this.resourceGuid = resourceGuid;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Short getValid() {
        return valid;
    }

    public void setValid(Short valid) {
        this.valid = valid;
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
