package com.mk.business.organization.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

/**
*Description: 
*Created by zhangnengwei on 2020-4-8 15:21
*/
@ApiModel(value="com.mk.business.organization.model.Organization")
@Table(name = "t_d_organization")
public class Organization implements Serializable {
    @Id
    @Column(name = "Org_Guid")
    @ApiModelProperty(value="null")
    private String orgGuid;

    @Column(name = "Region_Guid")
    @ApiModelProperty(value="null")
    private String regionGuid;

    @Column(name = "Org_P_Guid")
    @ApiModelProperty(value="null")
    private String orgPGuid;

    @Column(name = "Org_Code")
    @ApiModelProperty(value="null")
    private String orgCode;

    @Column(name = "Org_Name")
    @ApiModelProperty(value="null")
    private String orgName;

    @Column(name = "Short_Name")
    @ApiModelProperty(value="null")
    private String shortName;

    @Column(name = "Org_Cert")
    @ApiModelProperty(value="null")
    private String orgCert;

    @Column(name = "Finance_Dept_Guid")
    @ApiModelProperty(value="null")
    private String financeDeptGuid;

    @Column(name = "Org_Type")
    @ApiModelProperty(value="null")
    private String orgType;

    @Column(name = "`Valid`")
    @ApiModelProperty(value="null")
    private Short valid;

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="null")
    private String interfaceCode;

    private static final long serialVersionUID = 1L;

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
     * @return Org_P_Guid
     */
    public String getOrgPGuid() {
        return orgPGuid;
    }

    /**
     * @param orgPGuid
     */
    public void setOrgPGuid(String orgPGuid) {
        this.orgPGuid = orgPGuid;
    }

    /**
     * @return Org_Code
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * @param orgCode
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
     * @return Org_Name
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return Short_Name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * @return Org_Cert
     */
    public String getOrgCert() {
        return orgCert;
    }

    /**
     * @param orgCert
     */
    public void setOrgCert(String orgCert) {
        this.orgCert = orgCert;
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
     * @return Org_Type
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * @param orgType
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType;
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
}