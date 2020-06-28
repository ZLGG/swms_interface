package com.mk.business.acceptance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
*Description: 合同履约验收
*Created by zhangnengwei on 2020-4-7 19:16
*/
@ApiModel(value="com.mk.business.acceptance.model.Acceptance")
@Table(name = "t_a_acceptance")
public class Acceptance implements Serializable {
    @Id
    @Column(name = "Acceptance_Guid")
    @ApiModelProperty(value="null")
    private String acceptanceGuid;

    @Column(name = "Acceptance_Code")
    @ApiModelProperty(value="null")
    private String acceptanceCode;

    @Column(name = "Region_Guid")
    @ApiModelProperty(value="null")
    private String regionGuid;

    @Column(name = "`Year`")
    @ApiModelProperty(value="null")
    private Short year;

    @Column(name = "Org_Guid")
    @ApiModelProperty(value="null")
    private String orgGuid;

    @Column(name = "Finance_Dept_Guid")
    @ApiModelProperty(value="null")
    private String financeDeptGuid;

    @Column(name = "Contract_Guid")
    @ApiModelProperty(value="null")
    private String contractGuid;

    @Column(name = "Pay_Money")
    @ApiModelProperty(value="null")
    private BigDecimal payMoney;

    @Column(name = "Plan_Acceptance_Date")
    @ApiModelProperty(value="null")
    private Date planAcceptanceDate;

    @Column(name = "Is_Simple")
    @ApiModelProperty(value="null")
    private String isSimple;

    @Column(name = "Acceptance_Type")
    @ApiModelProperty(value="null")
    private String acceptanceType;

    @Column(name = "Agent_Guid")
    @ApiModelProperty(value="null")
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

    @Column(name = "Actual_Acceptance_Date")
    @ApiModelProperty(value="null")
    private Date actualAcceptanceDate;

    @Column(name = "Verdict_State")
    @ApiModelProperty(value="null")
    private String verdictState;

    @Column(name = "Org_Opinion")
    @ApiModelProperty(value="null")
    private String orgOpinion;

    @Column(name = "Assessors_Name")
    @ApiModelProperty(value="null")
    private String assessorsName;

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

    public Integer getBizValid() {
        return bizValid;
    }

    public void setBizValid(Integer bizValid) {
        this.bizValid = bizValid;
    }

    public Date getBizTimeStamp() {
        return bizTimeStamp;
    }

    public void setBizTimeStamp(Date bizTimeStamp) {
        this.bizTimeStamp = bizTimeStamp;
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

    private static final long serialVersionUID = 1L;

    /**
     * @return Acceptance_Guid
     */
    public String getAcceptanceGuid() {
        return acceptanceGuid;
    }

    /**
     * @param acceptanceGuid
     */
    public void setAcceptanceGuid(String acceptanceGuid) {
        this.acceptanceGuid = acceptanceGuid;
    }

    /**
     * @return Acceptance_Code
     */
    public String getAcceptanceCode() {
        return acceptanceCode;
    }

    /**
     * @param acceptanceCode
     */
    public void setAcceptanceCode(String acceptanceCode) {
        this.acceptanceCode = acceptanceCode;
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
     * @return Pay_Money
     */
    public BigDecimal getPayMoney() {
        return payMoney;
    }

    /**
     * @param payMoney
     */
    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    /**
     * @return Plan_Acceptance_Date
     */
    public Date getPlanAcceptanceDate() {
        return planAcceptanceDate;
    }

    /**
     * @param planAcceptanceDate
     */
    public void setPlanAcceptanceDate(Date planAcceptanceDate) {
        this.planAcceptanceDate = planAcceptanceDate;
    }

    /**
     * @return Is_Simple
     */
    public String getIsSimple() {
        return isSimple;
    }

    /**
     * @param isSimple
     */
    public void setIsSimple(String isSimple) {
        this.isSimple = isSimple;
    }

    /**
     * @return Acceptance_Type
     */
    public String getAcceptanceType() {
        return acceptanceType;
    }

    /**
     * @param acceptanceType
     */
    public void setAcceptanceType(String acceptanceType) {
        this.acceptanceType = acceptanceType;
    }

    /**
     * @return Agent_Guid
     */
    public String getAgentGuid() {
        return agentGuid;
    }

    /**
     * @param agentGuid
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
     * @return Actual_Acceptance_Date
     */
    public Date getActualAcceptanceDate() {
        return actualAcceptanceDate;
    }

    /**
     * @param actualAcceptanceDate
     */
    public void setActualAcceptanceDate(Date actualAcceptanceDate) {
        this.actualAcceptanceDate = actualAcceptanceDate;
    }

    /**
     * @return Verdict_State
     */
    public String getVerdictState() {
        return verdictState;
    }

    /**
     * @param verdictState
     */
    public void setVerdictState(String verdictState) {
        this.verdictState = verdictState;
    }

    /**
     * @return Org_Opinion
     */
    public String getOrgOpinion() {
        return orgOpinion;
    }

    /**
     * @param orgOpinion
     */
    public void setOrgOpinion(String orgOpinion) {
        this.orgOpinion = orgOpinion;
    }

    /**
     * @return Assessors_Name
     */
    public String getAssessorsName() {
        return assessorsName;
    }

    /**
     * @param assessorsName
     */
    public void setAssessorsName(String assessorsName) {
        this.assessorsName = assessorsName;
    }

    public Date getBizDate() {
        return bizDate;
    }

    public void setBizDate(Date bizDate) {
        this.bizDate = bizDate;
    }
}
