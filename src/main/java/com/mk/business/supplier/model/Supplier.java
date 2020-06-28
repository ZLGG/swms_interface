package com.mk.business.supplier.model;

import java.io.Serializable;
import java.util.Date;

/**
 * t_d_supplier
 * @author 
 */
public class Supplier implements Serializable {
    /**
     * 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    private String supplierGuid;

    /**
     * 工作单位
     */
    private String supplierCode;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    private String locationGuid;

    /**
     * 供应商规模
     */
    private String supplierSize;

    /**
     * 供应商特性
     */
    private String supplierFeatures;

    private String legendName;

    private String cellNumber;

    private Date pauseDate;

    private Date recoverDate;

    private String pauseReason;

    private Integer purActivity;

    private Integer bizValid;

    private Date bizDate;

    private Date bizTimeStamp;

    private String interfaceCode;

    private String dataResource;

    private static final long serialVersionUID = 1L;

    public Integer getPurActivity() {
        return purActivity;
    }

    public void setPurActivity(Integer purActivity) {
        this.purActivity = purActivity;
    }

    public String getSupplierGuid() {
        return supplierGuid;
    }

    public void setSupplierGuid(String supplierGuid) {
        this.supplierGuid = supplierGuid;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
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

    public String getSupplierSize() {
        return supplierSize;
    }

    public void setSupplierSize(String supplierSize) {
        this.supplierSize = supplierSize;
    }

    public String getSupplierFeatures() {
        return supplierFeatures;
    }

    public void setSupplierFeatures(String supplierFeatures) {
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

    public Date getPauseDate() {
        return pauseDate;
    }

    public void setPauseDate(Date pauseDate) {
        this.pauseDate = pauseDate;
    }

    public Date getRecoverDate() {
        return recoverDate;
    }

    public void setRecoverDate(Date recoverDate) {
        this.recoverDate = recoverDate;
    }

    public String getPauseReason() {
        return pauseReason;
    }

    public void setPauseReason(String pauseReason) {
        this.pauseReason = pauseReason;
    }

    public Integer getBizValid() {
        return bizValid;
    }

    public void setBizValid(Integer bizValid) {
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