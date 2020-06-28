package com.mk.business.buyplan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-14 19:02
 */
@ApiModel(value="com-mk-business-atest-model-Buyplanmoney")
@Table(name = "t_a_buyplanmoney")
public class Buyplanmoney implements Serializable {
    @Id
    @Column(name = "BuyPlan_Money_Guid")
    @ApiModelProperty(value="")
    private String buyplanMoneyGuid;

    @Column(name = "BuyPlan_Guid")
    @ApiModelProperty(value="")
    private String buyplanGuid;

    @Column(name = "BuyItem_Money_Guid")
    @ApiModelProperty(value="")
    private String buyitemMoneyGuid;

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
     * @return BuyItem_Money_Guid
     */
    public String getBuyitemMoneyGuid() {
        return buyitemMoneyGuid;
    }

    /**
     * @param buyitemMoneyGuid
     */
    public void setBuyitemMoneyGuid(String buyitemMoneyGuid) {
        this.buyitemMoneyGuid = buyitemMoneyGuid;
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
