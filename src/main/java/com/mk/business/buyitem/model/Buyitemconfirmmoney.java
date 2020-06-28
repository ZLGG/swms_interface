package com.mk.business.buyitem.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
*@date: 2020-4-26 15:44
*@author: Znw · Smile
*@Description:
*/
@ApiModel(value="com-mk-business-buyitem-model-Buyitemconfirmmoney")
@Table(name = "t_a_buyitemconfirmmoney")
public class Buyitemconfirmmoney implements Serializable {
    @Id
    @Column(name = "BuyitemConfirmMoneyGuid")
    @ApiModelProperty(value="")
    private String buyitemconfirmmoneyguid;

    @Column(name = "Buyitem_Confirm_Guid")
    @ApiModelProperty(value="")
    private String buyitemConfirmGuid;

    @Column(name = "Resource_Guid")
    @ApiModelProperty(value="")
    private String resourceGuid;

    /**
     * 金额
     */
    @Column(name = "Money")
    @ApiModelProperty(value="金额")
    private BigDecimal money;

    private static final long serialVersionUID = 1L;

    /**
     * @return BuyitemConfirmMoneyGuid
     */
    public String getBuyitemconfirmmoneyguid() {
        return buyitemconfirmmoneyguid;
    }

    /**
     * @param buyitemconfirmmoneyguid
     */
    public void setBuyitemconfirmmoneyguid(String buyitemconfirmmoneyguid) {
        this.buyitemconfirmmoneyguid = buyitemconfirmmoneyguid;
    }

    /**
     * @return Buyitem_Confirm_Guid
     */
    public String getBuyitemConfirmGuid() {
        return buyitemConfirmGuid;
    }

    /**
     * @param buyitemConfirmGuid
     */
    public void setBuyitemConfirmGuid(String buyitemConfirmGuid) {
        this.buyitemConfirmGuid = buyitemConfirmGuid;
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
     * 获取金额
     *
     * @return Money - 金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置金额
     *
     * @param money 金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
