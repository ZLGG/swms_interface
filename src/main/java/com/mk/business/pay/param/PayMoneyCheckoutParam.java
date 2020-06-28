package com.mk.business.pay.param;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @date: 2020-5-14 17:02
 * @author: Znw · Smile
 * @Description: 资金支付明细待校验参数
 */
public class PayMoneyCheckoutParam implements Serializable {

    private static final long serialVersionUID = -2165340027121825529L;
    @Column(name = "Pay_Guid")
    @ApiModelProperty(value="")
    private String payGuid;

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

    @Column(name = "Money")
    @ApiModelProperty(value="")
    private BigDecimal money;

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="")
    private String interfaceCode;

    @Column(name = "Data_Resource")
    @ApiModelProperty(value="")
    private String dataResource;

    public String getPayGuid() {
        return payGuid;
    }

    public void setPayGuid(String payGuid) {
        this.payGuid = payGuid;
    }

    public String getContractGuid() {
        return contractGuid;
    }

    public void setContractGuid(String contractGuid) {
        this.contractGuid = contractGuid;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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
