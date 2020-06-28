package com.mk.business.budget.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-15 16:50
 */
@ApiModel(value="com-mk-business-atest-model-Budgetmoney")
@Table(name = "t_a_budgetmoney")
public class Budgetmoney implements Serializable {
    @Id
    @Column(name = "Budget_Money_Guid")
    @ApiModelProperty(value="")
    private String budgetMoneyGuid;

    @Column(name = "PurCatalog_Type")
    @ApiModelProperty(value="")
    private String purcatalogType;

    @Column(name = "Resource_Guid")
    @ApiModelProperty(value="")
    private String resourceGuid;

    @Column(name = "Budget_Guid")
    @ApiModelProperty(value="")
    private String budgetGuid;

    @Column(name = "Money")
    @ApiModelProperty(value="")
    private BigDecimal money;

    @Column(name = "Is_Buyitem")
    @ApiModelProperty(value="")
    private Short isBuyitem;

    @Column(name = "Buyitem_Money")
    @ApiModelProperty(value="")
    private BigDecimal buyitemMoney;

    @Column(name = "Kind")
    @ApiModelProperty(value="")
    private String kind;

    @Column(name = "PurCatalog_Guid")
    @ApiModelProperty(value="")
    private String purcatalogGuid;

    @Column(name = "Is_Directional")
    @ApiModelProperty(value="")
    private Short isDirectional;

    @Column(name = "Is_Poverty_Relief")
    @ApiModelProperty(value="")
    private Short isPovertyRelief;

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
     * @return Budget_Money_Guid
     */
    public String getBudgetMoneyGuid() {
        return budgetMoneyGuid;
    }

    /**
     * @param budgetMoneyGuid
     */
    public void setBudgetMoneyGuid(String budgetMoneyGuid) {
        this.budgetMoneyGuid = budgetMoneyGuid;
    }

    /**
     * @return PurCatalog_Type
     */
    public String getPurcatalogType() {
        return purcatalogType;
    }

    /**
     * @param purcatalogType
     */
    public void setPurcatalogType(String purcatalogType) {
        this.purcatalogType = purcatalogType;
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
     * @return Is_Buyitem
     */
    public Short getIsBuyitem() {
        return isBuyitem;
    }

    /**
     * @param isBuyitem
     */
    public void setIsBuyitem(Short isBuyitem) {
        this.isBuyitem = isBuyitem;
    }

    /**
     * @return Buyitem_Money
     */
    public BigDecimal getBuyitemMoney() {
        return buyitemMoney;
    }

    /**
     * @param buyitemMoney
     */
    public void setBuyitemMoney(BigDecimal buyitemMoney) {
        this.buyitemMoney = buyitemMoney;
    }

    /**
     * @return Kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return PurCatalog_Guid
     */
    public String getPurcatalogGuid() {
        return purcatalogGuid;
    }

    /**
     * @param purcatalogGuid
     */
    public void setPurcatalogGuid(String purcatalogGuid) {
        this.purcatalogGuid = purcatalogGuid;
    }

    /**
     * @return Is_Directional
     */
    public Short getIsDirectional() {
        return isDirectional;
    }

    /**
     * @param isDirectional
     */
    public void setIsDirectional(Short isDirectional) {
        this.isDirectional = isDirectional;
    }

    /**
     * @return Is_Poverty_Relief
     */
    public Short getIsPovertyRelief() {
        return isPovertyRelief;
    }

    /**
     * @param isPovertyRelief
     */
    public void setIsPovertyRelief(Short isPovertyRelief) {
        this.isPovertyRelief = isPovertyRelief;
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
