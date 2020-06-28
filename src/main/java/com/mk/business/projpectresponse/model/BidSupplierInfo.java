package com.mk.business.projpectresponse.model;

public class BidSupplierInfo {
    private String bidSupplierInfoGuid;
    private String responseGuid;
    private String supplierGuid;
    private String supplierCertCode;
    private String supplierName;
    private String locationGuid;
    private Integer supplierSize;
    private Integer supplierFeatures;
    private String legendName;
    private String cellNumber;

    public String getSupplierCertCode() {
        return supplierCertCode;
    }

    public void setSupplierCertCode(String supplierCertCode) {
        this.supplierCertCode = supplierCertCode;
    }

    public String getBidSupplierInfoGuid() {
        return bidSupplierInfoGuid;
    }

    public void setBidSupplierInfoGuid(String bidSupplierInfoGuid) {
        this.bidSupplierInfoGuid = bidSupplierInfoGuid;
    }

    public String getResponseGuid() {
        return responseGuid;
    }

    public void setResponseGuid(String responseGuid) {
        this.responseGuid = responseGuid;
    }

    public String getSupplierGuid() {
        return supplierGuid;
    }

    public void setSupplierGuid(String supplierGuid) {
        this.supplierGuid = supplierGuid;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLocationGuid() {
        return locationGuid;
    }

    public void setLocationGuid(String locationGuid) {
        this.locationGuid = locationGuid;
    }

    public Integer getSupplierSize() {
        return supplierSize;
    }

    public void setSupplierSize(Integer supplierSize) {
        this.supplierSize = supplierSize;
    }

    public Integer getSupplierFeatures() {
        return supplierFeatures;
    }

    public void setSupplierFeatures(Integer supplierFeatures) {
        this.supplierFeatures = supplierFeatures;
    }

    public String getLegendName() {
        return legendName;
    }

    public void setLegendName(String legendName) {
        this.legendName = legendName;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

}
