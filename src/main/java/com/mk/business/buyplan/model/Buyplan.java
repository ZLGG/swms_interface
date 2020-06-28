package com.mk.business.buyplan.model;

import com.mk.business.audithistory.model.Audithistory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-14 19:01
 */
@ApiModel(value="com-mk-business-atest-model-Buyplan")
@Table(name = "t_a_buyplan")
public class Buyplan implements Serializable {
    @Id
    @Column(name = "BuyPlan_Guid")
    @ApiModelProperty(value="")
    private String buyplanGuid;

    /**
     * 执行书编号
     */
    @Column(name = "BuyPlan_Archive_Code")
    @ApiModelProperty(value="执行书编号")
    private String buyplanArchiveCode;

    /**
     * 计划流水号
     */
    @Column(name = "BuyPlan_Code")
    @ApiModelProperty(value="计划流水号")
    private String buyplanCode;

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
     * 组织形式（1：政府集中采购，2：部门集中采购，0:分散采购）
     */
    @Column(name = "Kind")
    @ApiModelProperty(value="组织形式（1：政府集中采购，2：部门集中采购，0:分散采购）")
    private String kind;

    @Column(name = "PurCatalog_Type")
    @ApiModelProperty(value="")
    private String purcatalogType;

    @Column(name = "Platform_Type_Guid")
    @ApiModelProperty(value="")
    private String platformTypeGuid;

    @Column(name = "Platform_Guid")
    @ApiModelProperty(value="")
    private String platformGuid;

    /**
     * 是否直接购买（1是，0否）
     */
    @Column(name = "Is_Direct_Buy")
    @ApiModelProperty(value="是否直接购买")
    private Short isDirectBuy;

    /**
     * 采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)
     */
    @Column(name = "PurMethod")
    @ApiModelProperty(value="采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)")
    private String purmethod;

    @Column(name = "BuyPlan_Money")
    @ApiModelProperty(value="")
    private BigDecimal buyplanMoney;

    /**
     * 计划备案时间
     */
    @Column(name = "Create_Date")
    @ApiModelProperty(value="计划备案时间")
    private Date createDate;

    /**
     * 计划备案时间
     */
    @Column(name = "Archive_Date")
    @ApiModelProperty(value="计划备案时间")
    private Date archiveDate;

    /**
     * 采购机构Guid(null:为自行采购,not null:下达到集采机构)
     */
    @Column(name = "Agent_Guid")
    @ApiModelProperty(value="采购机构Guid(null:为自行采购,not null:下达到集采机构)")
    private String agentGuid;

    /**
     * 工作单位
     */
    @Column(name = "Agent_Code")
    @ApiModelProperty(value="工作单位")
    private String agentCode;

    /**
     * 供应商名称
     */
    @Column(name = "Agent_Name")
    @ApiModelProperty(value="供应商名称")
    private String agentName;

    /**
     * 采购机构Guid(null:为自行采购,not null:下达到集采机构)
     */
    @Column(name = "Agent_Type")
    @ApiModelProperty(value="采购机构Guid(null:为自行采购,not null:下达到集采机构)")
    private String agentType;

    /**
     * 是否采购进口产品(0:否,1:是)
     */
    @Column(name = "Imports")
    @ApiModelProperty(value="是否采购进口产品(0:否,1:是)")
    private Short imports;

    /**
     * 是否PPP
     */
    @Column(name = "PPP")
    @ApiModelProperty(value="是否PPP")
    private Short ppp;

    /**
     * 是否涉密
     */
    @Column(name = "Secret")
    @ApiModelProperty(value="是否涉密")
    private Short secret;

    /**
     * 录入类型（[11:项目采购计划，12:协议/定点采购计划，13：批量采购计划，14：资质采购计划]）
     */
    @Column(name = "Plan_Create_Type")
    @ApiModelProperty(value="录入类型（[11:项目采购计划，12:协议/定点采购计划，13：批量采购计划，14：资质采购计划]）")
    private String planCreateType;

    /**
     * 采购计划类型（1备案制，2核准制）
     */
    @Column(name = "Buy_Plan_Style")
    @ApiModelProperty(value="采购计划类型（1备案制，2核准制）")
    private String buyPlanStyle;

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
     * 获取执行书编号
     *
     * @return BuyPlan_Archive_Code - 执行书编号
     */
    public String getBuyplanArchiveCode() {
        return buyplanArchiveCode;
    }

    /**
     * 设置执行书编号
     *
     * @param buyplanArchiveCode 执行书编号
     */
    public void setBuyplanArchiveCode(String buyplanArchiveCode) {
        this.buyplanArchiveCode = buyplanArchiveCode;
    }

    /**
     * 获取计划流水号
     *
     * @return BuyPlan_Code - 计划流水号
     */
    public String getBuyplanCode() {
        return buyplanCode;
    }

    /**
     * 设置计划流水号
     *
     * @param buyplanCode 计划流水号
     */
    public void setBuyplanCode(String buyplanCode) {
        this.buyplanCode = buyplanCode;
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
     * 获取组织形式（1：政府集中采购，2：部门集中采购，0:分散采购）
     *
     * @return Kind - 组织形式（1：政府集中采购，2：部门集中采购，0:分散采购）
     */
    public String getKind() {
        return kind;
    }

    /**
     * 设置组织形式（1：政府集中采购，2：部门集中采购，0:分散采购）
     *
     * @param kind 组织形式（1：政府集中采购，2：部门集中采购，0:分散采购）
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
     * @return Platform_Type_Guid
     */
    public String getPlatformTypeGuid() {
        return platformTypeGuid;
    }

    /**
     * @param platformTypeGuid
     */
    public void setPlatformTypeGuid(String platformTypeGuid) {
        this.platformTypeGuid = platformTypeGuid;
    }

    /**
     * @return Platform_Guid
     */
    public String getPlatformGuid() {
        return platformGuid;
    }

    /**
     * @param platformGuid
     */
    public void setPlatformGuid(String platformGuid) {
        this.platformGuid = platformGuid;
    }

    /**
     * 获取是否直接购买
     *
     * @return Is_Direct_Buy - 是否直接购买
     */
    public Short getIsDirectBuy() {
        return isDirectBuy;
    }

    /**
     * 设置是否直接购买
     *
     * @param isDirectBuy 是否直接购买
     */
    public void setIsDirectBuy(Short isDirectBuy) {
        this.isDirectBuy = isDirectBuy;
    }

    /**
     * 获取采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)
     *
     * @return PurMethod - 采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)
     */
    public String getPurmethod() {
        return purmethod;
    }

    /**
     * 设置采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)
     *
     * @param purmethod 采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)
     */
    public void setPurmethod(String purmethod) {
        this.purmethod = purmethod;
    }

    /**
     * @return BuyPlan_Money
     */
    public BigDecimal getBuyplanMoney() {
        return buyplanMoney;
    }

    /**
     * @param buyplanMoney
     */
    public void setBuyplanMoney(BigDecimal buyplanMoney) {
        this.buyplanMoney = buyplanMoney;
    }

    /**
     * 获取计划备案时间
     *
     * @return Create_Date - 计划备案时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置计划备案时间
     *
     * @param createDate 计划备案时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取计划备案时间
     *
     * @return Archive_Date - 计划备案时间
     */
    public Date getArchiveDate() {
        return archiveDate;
    }

    /**
     * 设置计划备案时间
     *
     * @param archiveDate 计划备案时间
     */
    public void setArchiveDate(Date archiveDate) {
        this.archiveDate = archiveDate;
    }

    /**
     * 获取采购机构Guid(null:为自行采购,not null:下达到集采机构)
     *
     * @return Agent_Guid - 采购机构Guid(null:为自行采购,not null:下达到集采机构)
     */
    public String getAgentGuid() {
        return agentGuid;
    }

    /**
     * 设置采购机构Guid(null:为自行采购,not null:下达到集采机构)
     *
     * @param agentGuid 采购机构Guid(null:为自行采购,not null:下达到集采机构)
     */
    public void setAgentGuid(String agentGuid) {
        this.agentGuid = agentGuid;
    }

    /**
     * 获取工作单位
     *
     * @return Agent_Code - 工作单位
     */
    public String getAgentCode() {
        return agentCode;
    }

    /**
     * 设置工作单位
     *
     * @param agentCode 工作单位
     */
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    /**
     * 获取供应商名称
     *
     * @return Agent_Name - 供应商名称
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * 设置供应商名称
     *
     * @param agentName 供应商名称
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * 获取采购机构Guid(null:为自行采购,not null:下达到集采机构)
     *
     * @return Agent_Type - 采购机构Guid(null:为自行采购,not null:下达到集采机构)
     */
    public String getAgentType() {
        return agentType;
    }

    /**
     * 设置采购机构Guid(null:为自行采购,not null:下达到集采机构)
     *
     * @param agentType 采购机构Guid(null:为自行采购,not null:下达到集采机构)
     */
    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    /**
     * 获取是否采购进口产品(0:否,1:是)
     *
     * @return Imports - 是否采购进口产品(0:否,1:是)
     */
    public Short getImports() {
        return imports;
    }

    /**
     * 设置是否采购进口产品(0:否,1:是)
     *
     * @param imports 是否采购进口产品(0:否,1:是)
     */
    public void setImports(Short imports) {
        this.imports = imports;
    }

    /**
     * 获取是否PPP
     *
     * @return PPP - 是否PPP
     */
    public Short getPpp() {
        return ppp;
    }

    /**
     * 设置是否PPP
     *
     * @param ppp 是否PPP
     */
    public void setPpp(Short ppp) {
        this.ppp = ppp;
    }

    /**
     * 获取是否涉密
     *
     * @return Secret - 是否涉密
     */
    public Short getSecret() {
        return secret;
    }

    /**
     * 设置是否涉密
     *
     * @param secret 是否涉密
     */
    public void setSecret(Short secret) {
        this.secret = secret;
    }

    public String getPlanCreateType() {
        return planCreateType;
    }

    public void setPlanCreateType(String planCreateType) {
        this.planCreateType = planCreateType;
    }

    /**
     * 获取采购计划类型（1备案制，2核准制）
     *
     * @return Buy_Plan_Style - 采购计划类型（1备案制，2核准制）
     */
    public String getBuyPlanStyle() {
        return buyPlanStyle;
    }

    /**
     * 设置采购计划类型（1备案制，2核准制）
     *
     * @param buyPlanStyle 采购计划类型（1备案制，2核准制）
     */
    public void setBuyPlanStyle(String buyPlanStyle) {
        this.buyPlanStyle = buyPlanStyle;
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

    public Integer getBizValid() {
        return bizValid;
    }

    public void setBizValid(Integer bizValid) {
        this.bizValid = bizValid;
    }
}
