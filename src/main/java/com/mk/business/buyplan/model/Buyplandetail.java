package com.mk.business.buyplan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-14 19:02
 */
@ApiModel(value="com-mk-business-atest-model-TABuyplandetail")
@Table(name = "t_a_buyplandetail")
public class Buyplandetail implements Serializable {
    @Id
    @Column(name = "BuyPlan_Detail_Guid")
    @ApiModelProperty(value="")
    private String buyplanDetailGuid;

    @Column(name = "BuyPlan_Guid")
    @ApiModelProperty(value="")
    private String buyplanGuid;

    /**
     * 采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)
     */
    @Column(name = "Final_PurMethod")
    @ApiModelProperty(value="采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)")
    private String finalPurmethod;

    @Column(name = "PurCatalog_Type")
    @ApiModelProperty(value="")
    private String purcatalogType;

    @Column(name = "PurCatalog_Guid")
    @ApiModelProperty(value="")
    private String purcatalogGuid;

    @Column(name = "Platform_Type_Guid")
    @ApiModelProperty(value="")
    private String platformTypeGuid;

    @Column(name = "Platform_Guid")
    @ApiModelProperty(value="")
    private String platformGuid;

    /**
     * 计划备案时间
     */
    @Column(name = "Archive_Date")
    @ApiModelProperty(value="计划备案时间")
    private Date archiveDate;

    /**
     * 采购机构Guid(null:为自行采购,not null:下达到集采机构)
     */
    @Column(name = "Agent_Type")
    @ApiModelProperty(value="采购机构Guid(null:为自行采购,not null:下达到集采机构)")
    private String agentType;

    /**
     * 采购机构Guid(null:为自行采购,not null:下达到集采机构)
     */
    @Column(name = "Agent_Guid")
    @ApiModelProperty(value="采购机构Guid(null:为自行采购,not null:下达到集采机构)")
    private String agentGuid;

    /**
     * 是否采购进口产品(0:否,1:是)
     */
    @Column(name = "Imports")
    @ApiModelProperty(value="是否采购进口产品(0:否,1:是)")
    private Short imports;

    @Column(name = "Money")
    @ApiModelProperty(value="")
    private BigDecimal money;

    @Column(name = "Buy_Number")
    @ApiModelProperty(value="")
    private BigDecimal buyNumber;

    @Column(name = "Price")
    @ApiModelProperty(value="")
    private BigDecimal price;

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
     * @return BuyPlan_Detail_Guid
     */
    public String getBuyplanDetailGuid() {
        return buyplanDetailGuid;
    }

    /**
     * @param buyplanDetailGuid
     */
    public void setBuyplanDetailGuid(String buyplanDetailGuid) {
        this.buyplanDetailGuid = buyplanDetailGuid;
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
     * 获取采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)
     *
     * @return Final_PurMethod - 采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)
     */
    public String getFinalPurmethod() {
        return finalPurmethod;
    }

    /**
     * 设置采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)
     *
     * @param finalPurmethod 采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)
     */
    public void setFinalPurmethod(String finalPurmethod) {
        this.finalPurmethod = finalPurmethod;
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
     * @return Buy_Number
     */
    public BigDecimal getBuyNumber() {
        return buyNumber;
    }

    /**
     * @param buyNumber
     */
    public void setBuyNumber(BigDecimal buyNumber) {
        this.buyNumber = buyNumber;
    }

    /**
     * @return Price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
