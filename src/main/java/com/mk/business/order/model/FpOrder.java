package com.mk.business.order.model;

import com.mk.business.fpsupplier.model.FpSupplier;

import java.io.Serializable;
import java.util.List;

/**
 * t_fp_order
 * @author 
 */
public class FpOrder implements Serializable {
    private String orderId;

    private String purchaserOrgName;

    private String purchaserOrgBudgetCode;

    private String districtCode;

    private Long amount;

    private String dataResource;

    private List<FpItem> fpItems;

    private List<FpSupplier> fpSuppliers;

    public List<FpSupplier> getFpSuppliers() {
        return fpSuppliers;
    }

    public void setFpSuppliers(List<FpSupplier> fpSuppliers) {
        this.fpSuppliers = fpSuppliers;
    }

    public List<FpItem> getFpItems() {
        return fpItems;
    }

    public void setFpItems(List<FpItem> fpItems) {
        this.fpItems = fpItems;
    }

    private static final long serialVersionUID = 1L;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDataResource() {
        return dataResource;
    }

    public void setDataResource(String dataResource) {
        this.dataResource = dataResource;
    }
}