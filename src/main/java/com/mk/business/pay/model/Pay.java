package com.mk.business.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-15 16:54
 */
@ApiModel(value="com-mk-business-atest-model-Pay")
@Table(name = "t_a_pay")
public class Pay implements Serializable {
    @Id
    @Column(name = "Pay_Guid")
    @ApiModelProperty(value="")
    private String payGuid;

    @Column(name = "Contract_Guid")
    @ApiModelProperty(value="")
    private String contractGuid;

    /**
     * 支付申请单编号(一体化支付返回的付款信息为NULL)
     */
    @Column(name = "Pay_Code")
    @ApiModelProperty(value="支付申请单编号(一体化支付返回的付款信息为NULL)")
    private String payCode;

    @Column(name = "Region_Guid")
    @ApiModelProperty(value="")
    private String regionGuid;

    @Column(name = "`Year`")
    @ApiModelProperty(value="")
    private Short year;

    @Column(name = "Org_Guid")
    @ApiModelProperty(value="")
    private String orgGuid;

    @Column(name = "Finance_Dept_Guid")
    @ApiModelProperty(value="")
    private String financeDeptGuid;

    /**
     * 支付(冲销)时间
     */
    @Column(name = "Pay_Date")
    @ApiModelProperty(value="支付(冲销)时间")
    private Date payDate;

    /**
     * 财政资金支付方式(0:实拨,1:直接支付,2:授权支付)(单位对应的资金支付方式优先)
     */
    @Column(name = "Pay_Type")
    @ApiModelProperty(value="财政资金支付方式(0:实拨,1:直接支付,2:授权支付)(单位对应的资金支付方式优先)")
    private Integer payType;

    @Column(name = "Money")
    @ApiModelProperty(value="")
    private BigDecimal money;

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

    /**
     * 收款单位
     */
    @Column(name = "Account_Name")
    @ApiModelProperty(value="收款单位")
    private String accountName;

    /**
     * 开户银行
     */
    @Column(name = "Bank_Name")
    @ApiModelProperty(value="开户银行")
    private String bankName;

    /**
     * 银行账号
     */
    @Column(name = "Bank_Account")
    @ApiModelProperty(value="银行账号")
    private String bankAccount;

    @Column(name = "Biz_Valid")
    @ApiModelProperty(value="")
    private Integer bizValid;

    @Column(name = "Biz_Time_Stamp")
    @ApiModelProperty(value="")
    private Date bizTimeStamp;

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="")
    private String interfaceCode;

    @Column(name = "Data_Resource")
    @ApiModelProperty(value="")
    private String dataResource;

    @Column(name = "Biz_Date")
    @ApiModelProperty(value="")
    private Date bizDate;

    private static final long serialVersionUID = 1L;

    /**
     * @return Pay_Guid
     */
    public String getPayGuid() {
        return payGuid;
    }

    /**
     * @param payGuid
     */
    public void setPayGuid(String payGuid) {
        this.payGuid = payGuid;
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
     * 获取支付申请单编号(一体化支付返回的付款信息为NULL)
     *
     * @return Pay_Code - 支付申请单编号(一体化支付返回的付款信息为NULL)
     */
    public String getPayCode() {
        return payCode;
    }

    /**
     * 设置支付申请单编号(一体化支付返回的付款信息为NULL)
     *
     * @param payCode 支付申请单编号(一体化支付返回的付款信息为NULL)
     */
    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    /**
     * @return Region_Guid
     */
    public String getRegionGuid() {
        return regionGuid;
    }

    /**
     * @param regionGuid
     */
    public void setRegionGuid(String regionGuid) {
        this.regionGuid = regionGuid;
    }

    /**
     * @return Year
     */
    public Short getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(Short year) {
        this.year = year;
    }

    /**
     * @return Org_Guid
     */
    public String getOrgGuid() {
        return orgGuid;
    }

    /**
     * @param orgGuid
     */
    public void setOrgGuid(String orgGuid) {
        this.orgGuid = orgGuid;
    }

    /**
     * @return Finance_Dept_Guid
     */
    public String getFinanceDeptGuid() {
        return financeDeptGuid;
    }

    /**
     * @param financeDeptGuid
     */
    public void setFinanceDeptGuid(String financeDeptGuid) {
        this.financeDeptGuid = financeDeptGuid;
    }

    /**
     * 获取支付(冲销)时间
     *
     * @return Pay_Date - 支付(冲销)时间
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * 设置支付(冲销)时间
     *
     * @param payDate 支付(冲销)时间
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * 获取财政资金支付方式(0:实拨,1:直接支付,2:授权支付)(单位对应的资金支付方式优先)
     *
     * @return Pay_Type - 财政资金支付方式(0:实拨,1:直接支付,2:授权支付)(单位对应的资金支付方式优先)
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置财政资金支付方式(0:实拨,1:直接支付,2:授权支付)(单位对应的资金支付方式优先)
     *
     * @param payType 财政资金支付方式(0:实拨,1:直接支付,2:授权支付)(单位对应的资金支付方式优先)
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * @return Money
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
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

    /**
     * 获取收款单位
     *
     * @return Account_Name - 收款单位
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置收款单位
     *
     * @param accountName 收款单位
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 获取开户银行
     *
     * @return Bank_Name - 开户银行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置开户银行
     *
     * @param bankName 开户银行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取银行账号
     *
     * @return Bank_Account - 银行账号
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置银行账号
     *
     * @param bankAccount 银行账号
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Integer getBizValid() {
        return bizValid;
    }

    public void setBizValid(Integer bizValid) {
        this.bizValid = bizValid;
    }

    /**
     * @return Biz_Time_Stamp
     */
    public Date getBizTimeStamp() {
        return bizTimeStamp;
    }

    /**
     * @param bizTimeStamp
     */
    public void setBizTimeStamp(Date bizTimeStamp) {
        this.bizTimeStamp = bizTimeStamp;
    }

    /**
     * @return Interface_Code
     */
    public String getInterfaceCode() {
        return interfaceCode;
    }

    /**
     * @param interfaceCode
     */
    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    /**
     * @return Data_Resource
     */
    public String getDataResource() {
        return dataResource;
    }

    /**
     * @param dataResource
     */
    public void setDataResource(String dataResource) {
        this.dataResource = dataResource;
    }

    public Date getBizDate() {
        return bizDate;
    }

    public void setBizDate(Date bizDate) {
        this.bizDate = bizDate;
    }
}
