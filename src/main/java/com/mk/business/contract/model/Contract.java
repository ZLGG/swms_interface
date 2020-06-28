package com.mk.business.contract.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *@date: 2020-5-8 13:39
 *@author: Znw · Smile
 *@Description:
 */
@ApiModel(value="com-mk-business-bizattachment-model-Contract")
@Table(name = "t_a_contract")
public class Contract implements Serializable {
    @Id
    @Column(name = "Contract_Guid")
    @ApiModelProperty(value="")
    private String contractGuid;

    /**
     * 合同履行状态(0:履行中,1:完成,2:终止,默认:0)
     */
    @Column(name = "Contract_State")
    @ApiModelProperty(value="合同履行状态(0:履行中,1:完成,2:终止,默认:0)")
    private String contractState;

    @Column(name = "Contract_Archive_Code")
    @ApiModelProperty(value="")
    private String contractArchiveCode;

    /**
     * 计划流水号
     */
    @Column(name = "Contract_Code")
    @ApiModelProperty(value="计划流水号")
    private String contractCode;

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

    @Column(name = "BuyPlan_Guid")
    @ApiModelProperty(value="")
    private String buyplanGuid;

    @Column(name = "BuyPlan_Money")
    @ApiModelProperty(value="")
    private BigDecimal buyplanMoney;

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
     * 是否直接购买
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

    /**
     * 采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)
     */
    @Column(name = "Final_PurMethod")
    @ApiModelProperty(value="采购方式(1:公开招标,2:邀请招标,3:竞争性谈判,4:询价,5:单一来源,6:竞争性磋商)(交易平台=2和3时为NULL)")
    private String finalPurmethod;

    /**
     * （×）代理机构Guid
     */
    @Column(name = "Agent_Guid")
    @ApiModelProperty(value="（×）代理机构Guid")
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
     * 项目开标时间
     */
    @Column(name = "Buy_Date")
    @ApiModelProperty(value="项目开标时间")
    private Date buyDate;

    /**
     * 采购项目Guid（如果是内网招投标则不为空）
     */
    @Column(name = "Project_Guid")
    @ApiModelProperty(value="采购项目Guid（如果是内网招投标则不为空）")
    private String projectGuid;

    /**
     * 编号
     */
    @Column(name = "Project_Code")
    @ApiModelProperty(value="编号")
    private String projectCode;

    /**
     * 名称
     */
    @Column(name = "Project_Name")
    @ApiModelProperty(value="名称")
    private String projectName;

    /**
     * 采购标项Guid（如果是内网招投标则不为空）
     */
    @Column(name = "Bid_Guid")
    @ApiModelProperty(value="采购标项Guid（如果是内网招投标则不为空）")
    private String bidGuid;

    /**
     * 编号
     */
    @Column(name = "Bid_Code")
    @ApiModelProperty(value="编号")
    private String bidCode;

    /**
     * 名称
     */
    @Column(name = "Bid_Name")
    @ApiModelProperty(value="名称")
    private String bidName;

    /**
     * 合同总金额
     */
    @Column(name = "Total_Money")
    @ApiModelProperty(value="合同总金额")
    private BigDecimal totalMoney;

    /**
     * 签订时间
     */
    @Column(name = "Sign_Date")
    @ApiModelProperty(value="签订时间")
    private Date signDate;

    /**
     * 合同备案时间
     */
    @Column(name = "Archive_Date")
    @ApiModelProperty(value="合同备案时间")
    private Date archiveDate;

    /**
     * 合同付款方式(0:分期付款,1:一次性付款)
     */
    @Column(name = "Contract_Pay_Type")
    @ApiModelProperty(value="合同付款方式(0:分期付款,1:一次性付款)")
    private String contractPayType;

    /**
     * 分期付款次数
     */
    @Column(name = "Pay_Count")
    @ApiModelProperty(value="分期付款次数")
    private BigDecimal payCount;

    /**
     * 合同开始时间
     */
    @Column(name = "Start_Date")
    @ApiModelProperty(value="合同开始时间")
    private Date startDate;

    /**
     * 合同结束时间
     */
    @Column(name = "End_Date")
    @ApiModelProperty(value="合同结束时间")
    private Date endDate;

    /**
     * 合同应收账款质押融资(1:是,0:否,默认:0)
     */
    @Column(name = "Mortgage")
    @ApiModelProperty(value="合同应收账款质押融资(1:是,0:否,默认:0)")
    private Short mortgage;

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
     * 供应商规模
     */
    @Column(name = "Supplier_Size")
    @ApiModelProperty(value="供应商规模")
    private String supplierSize;

    /**
     * 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    @Column(name = "Location_Guid")
    @ApiModelProperty(value="供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空")
    private String locationGuid;

    /**
     * 供应商特性
     */
    @Column(name = "Supplier_Features")
    @ApiModelProperty(value="供应商特性")
    private String supplierFeatures;

    @Column(name = "Biz_Valid")
    @ApiModelProperty(value="")
    private Long bizValid;

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
     * 原合同Guid
     */
    @Column(name = "Contract_PGuid")
    @ApiModelProperty(value="原合同Guid")
    private String contractPguid;

    /**
     * 合同拟定方式
     */
    @Column(name = "Contract_Create_Type")
    @ApiModelProperty(value="合同拟定方式")
    private Integer contractCreateType;

    private static final long serialVersionUID = 1L;

    /**
     * @return Contract_Guid
     */
    public String getContractGuid() {
        return contractGuid;
    }

    /**
     * @param contractGuid
     */
    public void setContractGuid(String contractGuid) {
        this.contractGuid = contractGuid;
    }

    /**
     * 获取合同履行状态(0:履行中,1:完成,2:终止,默认:0)
     *
     * @return Contract_State - 合同履行状态(0:履行中,1:完成,2:终止,默认:0)
     */
    public String getContractState() {
        return contractState;
    }

    /**
     * 设置合同履行状态(0:履行中,1:完成,2:终止,默认:0)
     *
     * @param contractState 合同履行状态(0:履行中,1:完成,2:终止,默认:0)
     */
    public void setContractState(String contractState) {
        this.contractState = contractState;
    }

    /**
     * @return Contract_Archive_Code
     */
    public String getContractArchiveCode() {
        return contractArchiveCode;
    }

    /**
     * @param contractArchiveCode
     */
    public void setContractArchiveCode(String contractArchiveCode) {
        this.contractArchiveCode = contractArchiveCode;
    }

    /**
     * 获取计划流水号
     *
     * @return Contract_Code - 计划流水号
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * 设置计划流水号
     *
     * @param contractCode 计划流水号
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
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
     * 获取（×）代理机构Guid
     *
     * @return Agent_Guid - （×）代理机构Guid
     */
    public String getAgentGuid() {
        return agentGuid;
    }

    /**
     * 设置（×）代理机构Guid
     *
     * @param agentGuid （×）代理机构Guid
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
     * 获取项目开标时间
     *
     * @return Buy_Date - 项目开标时间
     */
    public Date getBuyDate() {
        return buyDate;
    }

    /**
     * 设置项目开标时间
     *
     * @param buyDate 项目开标时间
     */
    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    /**
     * 获取采购项目Guid（如果是内网招投标则不为空）
     *
     * @return Project_Guid - 采购项目Guid（如果是内网招投标则不为空）
     */
    public String getProjectGuid() {
        return projectGuid;
    }

    /**
     * 设置采购项目Guid（如果是内网招投标则不为空）
     *
     * @param projectGuid 采购项目Guid（如果是内网招投标则不为空）
     */
    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    /**
     * 获取编号
     *
     * @return Project_Code - 编号
     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * 设置编号
     *
     * @param projectCode 编号
     */
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    /**
     * 获取名称
     *
     * @return Project_Name - 名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置名称
     *
     * @param projectName 名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取采购标项Guid（如果是内网招投标则不为空）
     *
     * @return Bid_Guid - 采购标项Guid（如果是内网招投标则不为空）
     */
    public String getBidGuid() {
        return bidGuid;
    }

    /**
     * 设置采购标项Guid（如果是内网招投标则不为空）
     *
     * @param bidGuid 采购标项Guid（如果是内网招投标则不为空）
     */
    public void setBidGuid(String bidGuid) {
        this.bidGuid = bidGuid;
    }

    /**
     * 获取编号
     *
     * @return Bid_Code - 编号
     */
    public String getBidCode() {
        return bidCode;
    }

    /**
     * 设置编号
     *
     * @param bidCode 编号
     */
    public void setBidCode(String bidCode) {
        this.bidCode = bidCode;
    }

    /**
     * 获取名称
     *
     * @return Bid_Name - 名称
     */
    public String getBidName() {
        return bidName;
    }

    /**
     * 设置名称
     *
     * @param bidName 名称
     */
    public void setBidName(String bidName) {
        this.bidName = bidName;
    }

    /**
     * 获取合同总金额
     *
     * @return Total_Money - 合同总金额
     */
    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    /**
     * 设置合同总金额
     *
     * @param totalMoney 合同总金额
     */
    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * 获取签订时间
     *
     * @return Sign_Date - 签订时间
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * 设置签订时间
     *
     * @param signDate 签订时间
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /**
     * 获取合同备案时间
     *
     * @return Archive_Date - 合同备案时间
     */
    public Date getArchiveDate() {
        return archiveDate;
    }

    /**
     * 设置合同备案时间
     *
     * @param archiveDate 合同备案时间
     */
    public void setArchiveDate(Date archiveDate) {
        this.archiveDate = archiveDate;
    }

    public String getContractPayType() {
        return contractPayType;
    }

    public void setContractPayType(String contractPayType) {
        this.contractPayType = contractPayType;
    }

    /**
     * 获取分期付款次数
     *
     * @return Pay_Count - 分期付款次数
     */
    public BigDecimal getPayCount() {
        return payCount;
    }

    /**
     * 设置分期付款次数
     *
     * @param payCount 分期付款次数
     */
    public void setPayCount(BigDecimal payCount) {
        this.payCount = payCount;
    }

    /**
     * 获取合同开始时间
     *
     * @return Start_Date - 合同开始时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置合同开始时间
     *
     * @param startDate 合同开始时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取合同结束时间
     *
     * @return End_Date - 合同结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置合同结束时间
     *
     * @param endDate 合同结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取合同应收账款质押融资(1:是,0:否,默认:0)
     *
     * @return Mortgage - 合同应收账款质押融资(1:是,0:否,默认:0)
     */
    public Short getMortgage() {
        return mortgage;
    }

    /**
     * 设置合同应收账款质押融资(1:是,0:否,默认:0)
     *
     * @param mortgage 合同应收账款质押融资(1:是,0:否,默认:0)
     */
    public void setMortgage(Short mortgage) {
        this.mortgage = mortgage;
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

    /**
     * 获取供应商规模
     *
     * @return Supplier_Size - 供应商规模
     */
    public String getSupplierSize() {
        return supplierSize;
    }

    /**
     * 设置供应商规模
     *
     * @param supplierSize 供应商规模
     */
    public void setSupplierSize(String supplierSize) {
        this.supplierSize = supplierSize;
    }

    /**
     * 获取供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     *
     * @return Location_Guid - 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    public String getLocationGuid() {
        return locationGuid;
    }

    /**
     * 设置供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     *
     * @param locationGuid 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    public void setLocationGuid(String locationGuid) {
        this.locationGuid = locationGuid;
    }

    /**
     * 获取供应商特性
     *
     * @return Supplier_Features - 供应商特性
     */
    public String getSupplierFeatures() {
        return supplierFeatures;
    }

    /**
     * 设置供应商特性
     *
     * @param supplierFeatures 供应商特性
     */
    public void setSupplierFeatures(String supplierFeatures) {
        this.supplierFeatures = supplierFeatures;
    }

    public Long getBizValid() {
        return bizValid;
    }

    public void setBizValid(Long bizValid) {
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

    /**
     * @return Biz_Date
     */
    public Date getBizDate() {
        return bizDate;
    }

    /**
     * @param bizDate
     */
    public void setBizDate(Date bizDate) {
        this.bizDate = bizDate;
    }

    /**
     * 获取原合同Guid
     *
     * @return Contract_PGuid - 原合同Guid
     */
    public String getContractPguid() {
        return contractPguid;
    }

    /**
     * 设置原合同Guid
     *
     * @param contractPguid 原合同Guid
     */
    public void setContractPguid(String contractPguid) {
        this.contractPguid = contractPguid;
    }

    /**
     * 获取合同拟定方式
     *
     * @return Contract_Create_Type - 合同拟定方式
     */
    public Integer getContractCreateType() {
        return contractCreateType;
    }

    /**
     * 设置合同拟定方式
     *
     * @param contractCreateType 合同拟定方式
     */
    public void setContractCreateType(Integer contractCreateType) {
        this.contractCreateType = contractCreateType;
    }
}
