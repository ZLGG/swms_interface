package com.mk.business.project.model;

import java.math.BigDecimal;
import java.util.Date;

public class Project {
    private String regionGuid;
    private Integer isDeposit;
    private String depositRcvAccountName;
    private String depositRcvAccount;
    private Date depositRcvTime;
    private BigDecimal depositMoney;
    private Integer isAcceptUnion;
    private Integer isPriceDiscount;
    private Integer procurementPublished;
    private Date procurementPublishTime;
    private String procurementUrl;
    private Integer correctionPublished;
    private Date correctionPublishTime;
    private String correctionUrl;
    private Integer resultPublished;
    private String resultUrl;

    private String projectGuid;
    private String platformTypeGuid;
    private String platformGuid;
    private String projectNo;
    private String projectName;
    private BigDecimal projectMoney;
    private String requirement;
    private String productInfoUrl;
    private Integer projectState;
    private Integer purMethod;
    private String agentGuid;
    private String agentCode;
    private String agentName;
    private Integer agentType;
    private Date responseStartTime;
    private Date responseEndTime;
    private Date resultPublishTime;
    private Integer bizValid;
    private Date bizDate;
    private Date bizTimeStamp;
    private String interfaceCode;
    private String dataResource;


    public String getRegionGuid() {
        return regionGuid;
    }

    public void setRegionGuid(String regionGuid) {
        this.regionGuid = regionGuid;
    }

    public Integer getIsDeposit() {
        return isDeposit;
    }

    public void setIsDeposit(Integer isDeposit) {
        this.isDeposit = isDeposit;
    }

    public String getDepositRcvAccountName() {
        return depositRcvAccountName;
    }

    public void setDepositRcvAccountName(String depositRcvAccountName) {
        this.depositRcvAccountName = depositRcvAccountName;
    }

    public String getDepositRcvAccount() {
        return depositRcvAccount;
    }

    public void setDepositRcvAccount(String depositRcvAccount) {
        this.depositRcvAccount = depositRcvAccount;
    }

    public Date getDepositRcvTime() {
        return depositRcvTime;
    }

    public void setDepositRcvTime(Date depositRcvTime) {
        this.depositRcvTime = depositRcvTime;
    }

    public BigDecimal getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(BigDecimal depositMoney) {
        this.depositMoney = depositMoney;
    }

    public Integer getIsAcceptUnion() {
        return isAcceptUnion;
    }

    public void setIsAcceptUnion(Integer isAcceptUnion) {
        this.isAcceptUnion = isAcceptUnion;
    }

    public Integer getIsPriceDiscount() {
        return isPriceDiscount;
    }

    public void setIsPriceDiscount(Integer isPriceDiscount) {
        this.isPriceDiscount = isPriceDiscount;
    }

    public Integer getProcurementPublished() {
        return procurementPublished;
    }

    public void setProcurementPublished(Integer procurementPublished) {
        this.procurementPublished = procurementPublished;
    }

    public Date getProcurementPublishTime() {
        return procurementPublishTime;
    }

    public void setProcurementPublishTime(Date procurementPublishTime) {
        this.procurementPublishTime = procurementPublishTime;
    }

    public String getProcurementUrl() {
        return procurementUrl;
    }

    public void setProcurementUrl(String procurementUrl) {
        this.procurementUrl = procurementUrl;
    }

    public Integer getCorrectionPublished() {
        return correctionPublished;
    }

    public void setCorrectionPublished(Integer correctionPublished) {
        this.correctionPublished = correctionPublished;
    }

    public Date getCorrectionPublishTime() {
        return correctionPublishTime;
    }

    public void setCorrectionPublishTime(Date correctionPublishTime) {
        this.correctionPublishTime = correctionPublishTime;
    }

    public String getCorrectionUrl() {
        return correctionUrl;
    }

    public void setCorrectionUrl(String correctionUrl) {
        this.correctionUrl = correctionUrl;
    }

    public Integer getResultPublished() {
        return resultPublished;
    }

    public void setResultPublished(Integer resultPublished) {
        this.resultPublished = resultPublished;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    public Date getBizDate() {
        return bizDate;
    }

    public void setBizDate(Date bizDate) {
        this.bizDate = bizDate;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }


    public String getPlatformTypeGuid() {
        return platformTypeGuid;
    }

    public void setPlatformTypeGuid(String platformTypeGuid) {
        this.platformTypeGuid = platformTypeGuid;
    }

    public String getPlatformGuid() {
        return platformGuid;
    }

    public void setPlatformGuid(String platformGuid) {
        this.platformGuid = platformGuid;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BigDecimal getProjectMoney() {
        return projectMoney;
    }

    public void setProjectMoney(BigDecimal projectMoney) {
        this.projectMoney = projectMoney;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getProductInfoUrl() {
        return productInfoUrl;
    }

    public void setProductInfoUrl(String productInfoUrl) {
        this.productInfoUrl = productInfoUrl;
    }

    public Integer getProjectState() {
        return projectState;
    }

    public void setProjectState(Integer projectState) {
        this.projectState = projectState;
    }

    public Integer getPurMethod() {
        return purMethod;
    }

    public void setPurMethod(Integer purMethod) {
        this.purMethod = purMethod;
    }

    public String getAgentGuid() {
        return agentGuid;
    }

    public void setAgentGuid(String agentGuid) {
        this.agentGuid = agentGuid;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getAgentType() {
        return agentType;
    }

    public void setAgentType(Integer agentType) {
        this.agentType = agentType;
    }

    public Date getResponseStartTime() {
        return responseStartTime;
    }

    public void setResponseStartTime(Date responseStartTime) {
        this.responseStartTime = responseStartTime;
    }

    public Date getResponseEndTime() {
        return responseEndTime;
    }

    public void setResponseEndTime(Date responseEndTime) {
        this.responseEndTime = responseEndTime;
    }

    public Date getResultPublishTime() {
        return resultPublishTime;
    }

    public void setResultPublishTime(Date resultPublishTime) {
        this.resultPublishTime = resultPublishTime;
    }

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
}
