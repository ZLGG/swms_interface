package com.mk.business.pay.param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @date: 2020-5-14 16:38
 * @author: Znw · Smile
 * @Description:资金支付待校验参数
 */
public class PayCheckoutParam implements Serializable {
    private static final long serialVersionUID = -25218083692259850L;
    private String contractGuid;
    private String payCode;
    private String regionGuid;
    private Short year;
    private String orgGuid;
    private String financeDeptGuid;
    private BigDecimal money;
    private String supplierName;
    private Integer bizValid;
    private String interfaceCode;
    private String dataResource;

    public String getContractGuid() {
        return contractGuid;
    }

    public void setContractGuid(String contractGuid) {
        this.contractGuid = contractGuid;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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
