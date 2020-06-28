package com.mk.business.budget.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-15 16:45
 */
/**
 * 支出预算
 */
@ApiModel(value="com-mk-business-atest-model-Budget")
@Table(name = "t_a_budget")
public class Budget implements Serializable {
    @Id
    @Column(name = "Budget_Guid")
    @ApiModelProperty(value="")
    private String budgetGuid;

    /**
     * 预算编号
     */
    @Column(name = "Budget_Code")
    @ApiModelProperty(value="预算编号")
    private String budgetCode;

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

    /**
     * 确认时间
     */
    @Column(name = "Confirm_Date")
    @ApiModelProperty(value="确认时间")
    private Date confirmDate;

    @Column(name = "Budget_Money")
    @ApiModelProperty(value="")
    private BigDecimal budgetMoney;

    @Column(name = "Is_Buyitem")
    @ApiModelProperty(value="")
    private Short isBuyitem;

    @Column(name = "Buyitem_Money")
    @ApiModelProperty(value="")
    private BigDecimal buyitemMoney;

    @Column(name = "Is_Directional")
    @ApiModelProperty(value="")
    private Short isDirectional;

    @Column(name = "Directional_Money")
    @ApiModelProperty(value="")
    private BigDecimal directionalMoney;

    @Column(name = "Is_Poverty_Relief")
    @ApiModelProperty(value="")
    private Short isPovertyRelief;

    @Column(name = "Poverty_Relief_Money")
    @ApiModelProperty(value="")
    private BigDecimal povertyReliefMoney;

    @Column(name = "Kind")
    @ApiModelProperty(value="")
    private String kind;

    @Column(name = "PurCatalog_Type")
    @ApiModelProperty(value="")
    private String purcatalogType;

    @Column(name = "PurCatalog_Guid")
    @ApiModelProperty(value="")
    private String purcatalogGuid;

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
     * @return Budget_Code - 预算编号
     */
    public String getBudgetCode() {
        return budgetCode;
    }

    /**
     * 设置预算编号
     *
     * @param budgetCode 预算编号
     */
    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
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

    /**
     * @return Budget_Money
     */
    public BigDecimal getBudgetMoney() {
        return budgetMoney;
    }

    /**
     * @param budgetMoney
     */
    public void setBudgetMoney(BigDecimal budgetMoney) {
        this.budgetMoney = budgetMoney;
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
     * @return Directional_Money
     */
    public BigDecimal getDirectionalMoney() {
        return directionalMoney;
    }

    /**
     * @param directionalMoney
     */
    public void setDirectionalMoney(BigDecimal directionalMoney) {
        this.directionalMoney = directionalMoney;
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
     * @return Poverty_Relief_Money
     */
    public BigDecimal getPovertyReliefMoney() {
        return povertyReliefMoney;
    }

    /**
     * @param povertyReliefMoney
     */
    public void setPovertyReliefMoney(BigDecimal povertyReliefMoney) {
        this.povertyReliefMoney = povertyReliefMoney;
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
