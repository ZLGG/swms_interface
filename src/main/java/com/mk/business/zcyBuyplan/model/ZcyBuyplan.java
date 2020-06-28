package com.mk.business.zcyBuyplan.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * t_zcy_buyplan
 * @author 
 */
public class ZcyBuyplan implements Serializable {
    private String purchaseplanId;

    private String financialPurchaseplanId;

    private String purchaserOrgName;

    private String purchaserOrgBudgetCode;

    private String status;

    private BigDecimal totalAmount;

    private String procurementMethod;

    /**
     * 1 为是，0为 否
     */
    private Integer isCommit;

    private String districtCode;

    private String dataResource;

    private static final long serialVersionUID = 1L;

    public String getPurchaseplanId() {
        return purchaseplanId;
    }

    public void setPurchaseplanId(String purchaseplanId) {
        this.purchaseplanId = purchaseplanId;
    }

    public String getFinancialPurchaseplanId() {
        return financialPurchaseplanId;
    }

    public void setFinancialPurchaseplanId(String financialPurchaseplanId) {
        this.financialPurchaseplanId = financialPurchaseplanId;
    }

    public String getPurchaserOrgName() {
        return purchaserOrgName;
    }

    public void setPurchaserOrgName(String purchaserOrgName) {
        this.purchaserOrgName = purchaserOrgName;
    }

    public String getPurchaserOrgBudgetCode() {
        return purchaserOrgBudgetCode;
    }

    public void setPurchaserOrgBudgetCode(String purchaserOrgBudgetCode) {
        this.purchaserOrgBudgetCode = purchaserOrgBudgetCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getProcurementMethod() {
        return procurementMethod;
    }

    public void setProcurementMethod(String procurementMethod) {
        this.procurementMethod = procurementMethod;
    }

    public Integer getIsCommit() {
        return isCommit;
    }

    public void setIsCommit(Integer isCommit) {
        this.isCommit = isCommit;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDataResource() {
        return dataResource;
    }

    public void setDataResource(String dataResource) {
        this.dataResource = dataResource;
    }
}