package com.mk.business.acceptance.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @date: 2020-5-14 17:18
 * @author: Znw · Smile
 * @Description:履约验收待校验参数
 */
public class AcceptanceCheckoutParam implements Serializable {
    private static final long serialVersionUID = 4554743753118802656L;
    private String acceptanceCode;
    private String regionGuid;
    private Short year;
    private String orgGuid;
    private String financeDeptGuid;
    private String contractGuid;
    private BigDecimal payMoney;
    private String isSimple;
    private Integer bizValid;
    private String interfaceCode;
    private String dataResource;

    public String getAcceptanceCode() {
        return acceptanceCode;
    }

    public void setAcceptanceCode(String acceptanceCode) {
        this.acceptanceCode = acceptanceCode;
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

    public String getContractGuid() {
        return contractGuid;
    }

    public void setContractGuid(String contractGuid) {
        this.contractGuid = contractGuid;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public String getIsSimple() {
        return isSimple;
    }

    public void setIsSimple(String isSimple) {
        this.isSimple = isSimple;
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
