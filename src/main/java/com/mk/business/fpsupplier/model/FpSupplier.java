package com.mk.business.fpsupplier.model;

import java.io.Serializable;

/**
 * t_fp_supplier
 * @author 
 */
public class FpSupplier implements Serializable {
    private String id;

    private String orderId;

    private String supplierCreditCode;

    private String supplierName;

    private String districtCode;

    private String supplierScale;

    private String supplierCharacteristic;

    private String industrySort;

    private String legalPerson;

    private String legalPersonPhone;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSupplierCreditCode() {
        return supplierCreditCode;
    }

    public void setSupplierCreditCode(String supplierCreditCode) {
        this.supplierCreditCode = supplierCreditCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getSupplierScale() {
        return supplierScale;
    }

    public void setSupplierScale(String supplierScale) {
        this.supplierScale = supplierScale;
    }

    public String getSupplierCharacteristic() {
        return supplierCharacteristic;
    }

    public void setSupplierCharacteristic(String supplierCharacteristic) {
        this.supplierCharacteristic = supplierCharacteristic;
    }

    public String getIndustrySort() {
        return industrySort;
    }

    public void setIndustrySort(String industrySort) {
        this.industrySort = industrySort;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalPersonPhone() {
        return legalPersonPhone;
    }

    public void setLegalPersonPhone(String legalPersonPhone) {
        this.legalPersonPhone = legalPersonPhone;
    }
}