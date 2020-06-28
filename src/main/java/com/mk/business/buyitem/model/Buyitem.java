package com.mk.business.buyitem.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
*Description:
*Created by zhangnengwei on 2020-4-14 14:47
*/
@ApiModel(value="com-mk-business-atest-model-Buyitem")
@Table(name = "t_a_buyitem")
public class Buyitem implements Serializable {
    @Id
    @Column(name = "BuyItem_Guid")
    @ApiModelProperty(value="")
    private String buyitemGuid;

    @Column(name = "Budget_Guid")
    @ApiModelProperty(value="")
    private String budgetGuid;

    /**
     * 预算编号
     */
    @Column(name = "BuyItem_Code")
    @ApiModelProperty(value="预算编号")
    private String buyitemCode;

    @Column(name = "Region_Guid")
    @ApiModelProperty(value="")
    private String regionGuid;

    @Column(name = "`Year`")
    @ApiModelProperty(value="")
    private Short year;

    @Column(name = "Org_Guid")
    @ApiModelProperty(value="")
    private String orgGuid;

    @Column(name = "Finance_Dept_Guid")
    @ApiModelProperty(value="")
    private String financeDeptGuid;

    @Column(name = "Kind")
    @ApiModelProperty(value="")
    private String kind;

    @Column(name = "PurCatalog_Type")
    @ApiModelProperty(value="")
    private String purcatalogType;

    @Column(name = "PurCatalog_Guid")
    @ApiModelProperty(value="")
    private String purcatalogGuid;

    /**
     * 预算来源(0:手工录入,1:接口对接,2：系统导入)
     */
    @Column(name = "Origin")
    @ApiModelProperty(value="预算来源(0:手工录入,1:接口对接,2：系统导入)")
    private String origin;

    /**
     * 购买数量
     */
    @Column(name = "Buy_Number")
    @ApiModelProperty(value="购买数量")
    private BigDecimal buyNumber;

    /**
     * 确认金额
     */
    @Column(name = "Confirm_Money")
    @ApiModelProperty(value="确认金额")
    private BigDecimal confirmMoney;

    @Column(name = "Buyitem_Money")
    @ApiModelProperty(value="")
    private BigDecimal buyitemMoney;

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
     * 获取预算编号
     *
     * @return BuyItem_Code - 预算编号
     */
    public String getBuyitemCode() {
        return buyitemCode;
    }

    /**
     * 设置预算编号
     *
     * @param buyitemCode 预算编号
     */
    public void setBuyitemCode(String buyitemCode) {
        this.buyitemCode = buyitemCode;
    }

    /**
     * @return Region_Guid
     */
    public String getRegionGuid() {
        return regionGuid;
    }

    /**
     * @param regionGuid
     */
    public void setRegionGuid(String regionGuid) {
        this.regionGuid = regionGuid;
    }

    /**
     * @return Year
     */
    public Short getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(Short year) {
        this.year = year;
    }

    /**
     * @return Org_Guid
     */
    public String getOrgGuid() {
        return orgGuid;
    }

    /**
     * @param orgGuid
     */
    public void setOrgGuid(String orgGuid) {
        this.orgGuid = orgGuid;
    }

    /**
     * @return Finance_Dept_Guid
     */
    public String getFinanceDeptGuid() {
        return financeDeptGuid;
    }

    /**
     * @param financeDeptGuid
     */
    public void setFinanceDeptGuid(String financeDeptGuid) {
        this.financeDeptGuid = financeDeptGuid;
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
     * 获取预算来源(0:手工录入,1:接口对接,2：系统导入)
     *
     * @return Origin - 预算来源(0:手工录入,1:接口对接,2：系统导入)
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * 设置预算来源(0:手工录入,1:接口对接,2：系统导入)
     *
     * @param origin 预算来源(0:手工录入,1:接口对接,2：系统导入)
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * 获取购买数量
     *
     * @return Buy_Number - 购买数量
     */
    public BigDecimal getBuyNumber() {
        return buyNumber;
    }

    /**
     * 设置购买数量
     *
     * @param buyNumber 购买数量
     */
    public void setBuyNumber(BigDecimal buyNumber) {
        this.buyNumber = buyNumber;
    }

    /**
     * 获取确认金额
     *
     * @return Confirm_Money - 确认金额
     */
    public BigDecimal getConfirmMoney() {
        return confirmMoney;
    }

    /**
     * 设置确认金额
     *
     * @param confirmMoney 确认金额
     */
    public void setConfirmMoney(BigDecimal confirmMoney) {
        this.confirmMoney = confirmMoney;
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
