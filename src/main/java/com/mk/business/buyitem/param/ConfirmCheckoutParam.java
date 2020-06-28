package com.mk.business.buyitem.param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @date: 2020-5-13 20:00
 * @author: Znw · Smile
 * @Description:
 */
public class ConfirmCheckoutParam implements Serializable {
    private static final long serialVersionUID = 9023396053325936232L;
    private String buyitemGuid;
    private BigDecimal money;
    private Date confirmDate;
    private Integer bizValid;
    private String interfaceCode;
    private String dataResource;

    public String getBuyitemGuid() {
        return buyitemGuid;
    }

    public void setBuyitemGuid(String buyitemGuid) {
        this.buyitemGuid = buyitemGuid;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
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
