package com.mk.business.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-15 16:54
 */
@ApiModel(value="com-mk-business-atest-model-Paymoney")
@Table(name = "t_a_paymoney")
public class Paymoney implements Serializable {
    @Id
    @Column(name = "Pay_Detail_Guid")
    @ApiModelProperty(value="")
    private String payDetailGuid;

    @Column(name = "Pay_Guid")
    @ApiModelProperty(value="")
    private String payGuid;

    @Column(name = "Contract_Money_Guid")
    @ApiModelProperty(value="")
    private String contractMoneyGuid;

    @Column(name = "Contract_Guid")
    @ApiModelProperty(value="")
    private String contractGuid;

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

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="")
    private String interfaceCode;

    @Column(name = "Data_Resource")
    @ApiModelProperty(value="")
    private String dataResource;

    private static final long serialVersionUID = 1L;

    /**
     * @return Pay_Detail_Guid
     */
    public String getPayDetailGuid() {
        return payDetailGuid;
    }

    /**
     * @param payDetailGuid
     */
    public void setPayDetailGuid(String payDetailGuid) {
        this.payDetailGuid = payDetailGuid;
    }

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
}
