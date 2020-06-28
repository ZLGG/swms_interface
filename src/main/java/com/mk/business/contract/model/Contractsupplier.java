package com.mk.business.contract.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-15 9:34
 */
@ApiModel(value="com-mk-business-atest-model-Contractsupplier")
@Table(name = "t_a_contractsupplier")
public class Contractsupplier implements Serializable {
    /**
     * 合同供应商主键
     */
    @Id
    @Column(name = "Contract_Supplier_Guid")
    @ApiModelProperty(value="合同供应商主键")
    private String contractSupplierGuid;

    @Column(name = "Contract_Guid")
    @ApiModelProperty(value="")
    private String contractGuid;

    /**
     * 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    @Column(name = "Supplier_Guid")
    @ApiModelProperty(value="供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空")
    private String supplierGuid;

    /**
     * 工作单位
     */
    @Column(name = "Supplier_CertCode")
    @ApiModelProperty(value="工作单位")
    private String supplierCertcode;

    /**
     * 供应商名称
     */
    @Column(name = "Supplier_Name")
    @ApiModelProperty(value="供应商名称")
    private String supplierName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取合同供应商主键
     *
     * @return Contract_Supplier_Guid - 合同供应商主键
     */
    public String getContractSupplierGuid() {
        return contractSupplierGuid;
    }

    /**
     * 设置合同供应商主键
     *
     * @param contractSupplierGuid 合同供应商主键
     */
    public void setContractSupplierGuid(String contractSupplierGuid) {
        this.contractSupplierGuid = contractSupplierGuid;
    }

    /**
     * @return Contract_Guid
     */
    public String getContractGuid() {
        return contractGuid;
    }

    /**
     * @param contractGuid
     */
    public void setContractGuid(String contractGuid) {
        this.contractGuid = contractGuid;
    }

    /**
     * 获取供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     *
     * @return Supplier_Guid - 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    public String getSupplierGuid() {
        return supplierGuid;
    }

    /**
     * 设置供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     *
     * @param supplierGuid 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    public void setSupplierGuid(String supplierGuid) {
        this.supplierGuid = supplierGuid;
    }

    /**
     * 获取工作单位
     *
     * @return Supplier_CertCode - 工作单位
     */
    public String getSupplierCertcode() {
        return supplierCertcode;
    }

    /**
     * 设置工作单位
     *
     * @param supplierCertcode 工作单位
     */
    public void setSupplierCertcode(String supplierCertcode) {
        this.supplierCertcode = supplierCertcode;
    }

    /**
     * 获取供应商名称
     *
     * @return Supplier_Name - 供应商名称
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * 设置供应商名称
     *
     * @param supplierName 供应商名称
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
