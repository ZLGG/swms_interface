package com.mk.business.buyitem.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-14 15:52
 */
@ApiModel(value="com-mk-business-atest-model-Buyitemconfirm")
@Table(name = "t_a_buyitemconfirm")
public class Buyitemconfirm implements Serializable {
    @Id
    @Column(name = "Buyitem_Confirm_Guid")
    @ApiModelProperty(value="")
    private String buyitemConfirmGuid;

    @Column(name = "BuyItem_Guid")
    @ApiModelProperty(value="")
    private String buyitemGuid;

    /**
     * 确认金额
     */
    @Column(name = "Money")
    @ApiModelProperty(value="确认金额")
    private BigDecimal money;

    /**
     * 确认时间
     */
    @Column(name = "Confirm_Date")
    @ApiModelProperty(value="确认时间")
    private Date confirmDate;

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

    /**
     * [t_a_buyitemconfirmmoney表]
     * 该字段因后面表结构变动而加上,所以没写VO类
     */
    @Transient
    private List<Buyitemconfirmmoney> buyitemconfirmmoneyList;

    private static final long serialVersionUID = 1L;

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
     * 获取确认金额
     *
     * @return Money - 确认金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置确认金额
     *
     * @param money 确认金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 获取确认时间
     *
     * @return Confirm_Date - 确认时间
     */
    public Date getConfirmDate() {
        return confirmDate;
    }

    /**
     * 设置确认时间
     *
     * @param confirmDate 确认时间
     */
    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
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

    public List<Buyitemconfirmmoney> getBuyitemconfirmmoneyList() {
        return buyitemconfirmmoneyList;
    }

    public void setBuyitemconfirmmoneyList(List<Buyitemconfirmmoney> buyitemconfirmmoneyList) {
        this.buyitemconfirmmoneyList = buyitemconfirmmoneyList;
    }
}
