package com.mk.business.trustinfo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * t_a_trustinfo
 * @author 
 */
public class Trustinfo implements Serializable {
    private String trustInfoGuid;

    private String buyplanGuid;

    private String buyplanDetailGuid;

    private String buyplanMoneyGuid;

    private Date trustDate;

    private Date acceptData;

    private Short trustState;

    private BigDecimal bizValid;

    private Date bizDate;

    private Date bizTimeStamp;

    private String interfaceCode;

    private String dataResource;

    private static final long serialVersionUID = 1L;

    public String getTrustInfoGuid() {
        return trustInfoGuid;
    }

    public void setTrustInfoGuid(String trustInfoGuid) {
        this.trustInfoGuid = trustInfoGuid;
    }

    public String getBuyplanGuid() {
        return buyplanGuid;
    }

    public void setBuyplanGuid(String buyplanGuid) {
        this.buyplanGuid = buyplanGuid;
    }

    public String getBuyplanDetailGuid() {
        return buyplanDetailGuid;
    }

    public void setBuyplanDetailGuid(String buyplanDetailGuid) {
        this.buyplanDetailGuid = buyplanDetailGuid;
    }

    public String getBuyplanMoneyGuid() {
        return buyplanMoneyGuid;
    }

    public void setBuyplanMoneyGuid(String buyplanMoneyGuid) {
        this.buyplanMoneyGuid = buyplanMoneyGuid;
    }

    public Date getTrustDate() {
        return trustDate;
    }

    public void setTrustDate(Date trustDate) {
        this.trustDate = trustDate;
    }

    public Date getAcceptData() {
        return acceptData;
    }

    public void setAcceptData(Date acceptData) {
        this.acceptData = acceptData;
    }

    public Short getTrustState() {
        return trustState;
    }

    public void setTrustState(Short trustState) {
        this.trustState = trustState;
    }

    public BigDecimal getBizValid() {
        return bizValid;
    }

    public void setBizValid(BigDecimal bizValid) {
        this.bizValid = bizValid;
    }

    public Date getBizDate() {
        return bizDate;
    }

    public void setBizDate(Date bizDate) {
        this.bizDate = bizDate;
    }

    public Date getBizTimeStamp() {
        return bizTimeStamp;
    }

    public void setBizTimeStamp(Date bizTimeStamp) {
        this.bizTimeStamp = bizTimeStamp;
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