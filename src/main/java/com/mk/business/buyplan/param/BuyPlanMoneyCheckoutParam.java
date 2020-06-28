package com.mk.business.buyplan.param;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @date: 2020-5-14 11:44
 * @author: Znw · Smile
 * @Description: 待校验参数
 */
public class BuyPlanMoneyCheckoutParam implements Serializable {

    private static final long serialVersionUID = -7420500769588440346L;
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

    @Column(name = "Money")
    @ApiModelProperty(value="")
    private BigDecimal money;

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

    public String getBuyplanGuid() {
        return buyplanGuid;
    }

    public void setBuyplanGuid(String buyplanGuid) {
        this.buyplanGuid = buyplanGuid;
    }

    public String getBuyitemMoneyGuid() {
        return buyitemMoneyGuid;
    }

    public void setBuyitemMoneyGuid(String buyitemMoneyGuid) {
        this.buyitemMoneyGuid = buyitemMoneyGuid;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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
