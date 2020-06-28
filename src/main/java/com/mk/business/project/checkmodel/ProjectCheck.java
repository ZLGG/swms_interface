package com.mk.business.project.checkmodel;

import java.math.BigDecimal;
import java.util.Date;

public class ProjectCheck {
    private String regionGuid;
    private String platformTypeGuid;
    private String platformGuid;
    private String projectNo;
    private String projectName;
    private BigDecimal projectMoney;
    private String requirement;
    private Integer isAcceptUnion;
    private Integer isPriceDiscount;
    private Integer projectState;
    private Integer purMethod;
    private Date responseEndTime;
    private Integer bizValid;
    private String interfaceCode;
    private String dataResource;

    public String getRegionGuid() {
        return regionGuid;
    }

    public void setRegionGuid(String regionGuid) {
        this.regionGuid = regionGuid;
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

    public Date getResponseEndTime() {
        return responseEndTime;
    }

    public void setResponseEndTime(Date responseEndTime) {
        this.responseEndTime = responseEndTime;
    }

    public Integer getBizValid() {
        return bizValid;
    }

    public void setBizValid(Integer bizValid) {
        this.bizValid = bizValid;
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
