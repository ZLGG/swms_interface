package com.mk.business.contract.param;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @date: 2020-5-14 15:58
 * @author: Znw · Smile
 * @Description:
 */
public class ContractMoneyCheckoutParam implements Serializable {
    private static final long serialVersionUID = 8008864296817751319L;

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

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="")
    private String interfaceCode;

    @Column(name = "Data_Resource")
    @ApiModelProperty(value="")
    private String dataResource;

    public String getContractGuid() {
        return contractGuid;
    }

    public void setContractGuid(String contractGuid) {
        this.contractGuid = contractGuid;
    }

    public String getBuyplanMoneyGuid() {
        return buyplanMoneyGuid;
    }

    public void setBuyplanMoneyGuid(String buyplanMoneyGuid) {
        this.buyplanMoneyGuid = buyplanMoneyGuid;
    }

    public String getBuyplanGuid() {
        return buyplanGuid;
    }

    public void setBuyplanGuid(String buyplanGuid) {
        this.buyplanGuid = buyplanGuid;
    }

    public String getBuyitemGuid() {
        return buyitemGuid;
    }

    public void setBuyitemGuid(String buyitemGuid) {
        this.buyitemGuid = buyitemGuid;
    }

    public String getResourceGuid() {
        return resourceGuid;
    }

    public void setResourceGuid(String resourceGuid) {
        this.resourceGuid = resourceGuid;
    }

    public String getBudgetGuid() {
        return budgetGuid;
    }

    public void setBudgetGuid(String budgetGuid) {
        this.budgetGuid = budgetGuid;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public String getCarryForwardType() {
        return carryForwardType;
    }

    public void setCarryForwardType(String carryForwardType) {
        this.carryForwardType = carryForwardType;
    }

    public Integer getBizValid() {
        return bizValid;
    }

    public void setBizValid(Integer bizValid) {
        this.bizValid = bizValid;
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
