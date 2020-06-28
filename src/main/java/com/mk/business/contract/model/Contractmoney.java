package com.mk.business.contract.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-15 9:34
 */
@ApiModel(value="com-mk-business-atest-model-Contractmoney")
@Table(name = "t_a_contractmoney")
public class Contractmoney implements Serializable {
    @Id
    @Column(name = "Contract_Money_Guid")
    @ApiModelProperty(value="")
    private String contractMoneyGuid;

    @Column(name = "Contract_Guid")
    @ApiModelProperty(value="")
    private String contractGuid;

    @Column(name = "BuyPlan_Money_Guid")
    @ApiModelProperty(value="")
    private String buyplanMoneyGuid;

    @Column(name = "BuyPlan_Guid")
    @ApiModelProperty(value="")
    private String buyplanGuid;

    @Column(name = "BuyItem_Guid")
    @ApiModelProperty(value="")
    private String buyitemGuid;

    @Column(name = "Resource_Guid")
    @ApiModelProperty(value="")
    private String resourceGuid;

    @Column(name = "Budget_Guid")
    @ApiModelProperty(value="")
    private String budgetGuid;

    @Column(name = "Money")
    @ApiModelProperty(value="")
    private BigDecimal money;

    /**
     * 对应预算的年度
     */
    @Column(name = "`Year`")
    @ApiModelProperty(value="对应预算的年度")
    private Short year;

    @Column(name = "Carry_Forward_Type")
    @ApiModelProperty(value="")
    private String carryForwardType;

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
     * @return Contract_Money_Guid
     */
    public String getContractMoneyGuid() {
        return contractMoneyGuid;
    }

    /**
     * @param contractMoneyGuid
     */
    public void setContractMoneyGuid(String contractMoneyGuid) {
        this.contractMoneyGuid = contractMoneyGuid;
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
     * @return BuyPlan_Money_Guid
     */
    public String getBuyplanMoneyGuid() {
        return buyplanMoneyGuid;
    }

    /**
     * @param buyplanMoneyGuid
     */
    public void setBuyplanMoneyGuid(String buyplanMoneyGuid) {
        this.buyplanMoneyGuid = buyplanMoneyGuid;
    }

    /**
     * @return BuyPlan_Guid
     */
    public String getBuyplanGuid() {
        return buyplanGuid;
    }

    /**
     * @param buyplanGuid
     */
    public void setBuyplanGuid(String buyplanGuid) {
        this.buyplanGuid = buyplanGuid;
    }

    /**
     * @return BuyItem_Guid
     */
    public String getBuyitemGuid() {
        return buyitemGuid;
    }

    /**
     * @param buyitemGuid
     */
    public void setBuyitemGuid(String buyitemGuid) {
        this.buyitemGuid = buyitemGuid;
    }

    /**
     * @return Resource_Guid
     */
    public String getResourceGuid() {
        return resourceGuid;
    }

    /**
     * @param resourceGuid
     */
    public void setResourceGuid(String resourceGuid) {
        this.resourceGuid = resourceGuid;
    }

    /**
     * @return Budget_Guid
     */
    public String getBudgetGuid() {
        return budgetGuid;
    }

    /**
     * @param budgetGuid
     */
    public void setBudgetGuid(String budgetGuid) {
        this.budgetGuid = budgetGuid;
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
     * 获取对应预算的年度
     *
     * @return Year - 对应预算的年度
     */
    public Short getYear() {
        return year;
    }

    /**
     * 设置对应预算的年度
     *
     * @param year 对应预算的年度
     */
    public void setYear(Short year) {
        this.year = year;
    }

    /**
     * @return Carry_Forward_Type
     */
    public String getCarryForwardType() {
        return carryForwardType;
    }

    /**
     * @param carryForwardType
     */
    public void setCarryForwardType(String carryForwardType) {
        this.carryForwardType = carryForwardType;
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
