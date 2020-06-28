package com.mk.business.buyitem.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-14 15:54
 */
@ApiModel(value="com-mk-business-atest-model-Buyitemmoney")
@Table(name = "t_a_buyitemmoney")
public class Buyitemmoney implements Serializable {
    @Id
    @Column(name = "BuyItem_Money_Guid")
    @ApiModelProperty(value="")
    private String buyitemMoneyGuid;

    @Column(name = "BuyItem_Guid")
    @ApiModelProperty(value="")
    private String buyitemGuid;

    @Column(name = "BudgetMoney_Guid")
    @ApiModelProperty(value="")
    private String budgetmoneyGuid;

    @Column(name = "Resource_Guid")
    @ApiModelProperty(value="")
    private String resourceGuid;

    @Column(name = "Budget_Guid")
    @ApiModelProperty(value="")
    private String budgetGuid;

    @Column(name = "Money")
    @ApiModelProperty(value="")
    private BigDecimal money;

    @Column(name = "`Valid`")
    @ApiModelProperty(value="")
    private Short valid;

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="")
    private String interfaceCode;

    @Column(name = "Data_Resource")
    @ApiModelProperty(value="")
    private String dataResource;

    private static final long serialVersionUID = 1L;

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
     * @return BudgetMoney_Guid
     */
    public String getBudgetmoneyGuid() {
        return budgetmoneyGuid;
    }

    /**
     * @param budgetmoneyGuid
     */
    public void setBudgetmoneyGuid(String budgetmoneyGuid) {
        this.budgetmoneyGuid = budgetmoneyGuid;
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
     * @return Valid
     */
    public Short getValid() {
        return valid;
    }

    /**
     * @param valid
     */
    public void setValid(Short valid) {
        this.valid = valid;
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
