package com.mk.business.financedept.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

/**
*Description: 
*Created by zhangnengwei on 2020-4-8 15:16
*/
@ApiModel(value="com.mk.business.financedept.model.Financedept")
@Table(name = "t_d_financedept")
public class Financedept implements Serializable {
    @Id
    @Column(name = "Finance_Dept_Guid")
    @ApiModelProperty(value="null")
    private String financeDeptGuid;

    @Column(name = "Region_Guid")
    @ApiModelProperty(value="null")
    private String regionGuid;

    @Column(name = "Finance_Dept_Code")
    @ApiModelProperty(value="null")
    private String financeDeptCode;

    @Column(name = "Finance_Dept_Name")
    @ApiModelProperty(value="null")
    private String financeDeptName;

    @Column(name = "Short_Name")
    @ApiModelProperty(value="null")
    private String shortName;

    @Column(name = "`Valid`")
    @ApiModelProperty(value="null")
    private Short valid;

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="null")
    private String interfaceCode;

    private static final long serialVersionUID = 1L;

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
     * @return Finance_Dept_Code
     */
    public String getFinanceDeptCode() {
        return financeDeptCode;
    }

    /**
     * @param financeDeptCode
     */
    public void setFinanceDeptCode(String financeDeptCode) {
        this.financeDeptCode = financeDeptCode;
    }

    /**
     * @return Finance_Dept_Name
     */
    public String getFinanceDeptName() {
        return financeDeptName;
    }

    /**
     * @param financeDeptName
     */
    public void setFinanceDeptName(String financeDeptName) {
        this.financeDeptName = financeDeptName;
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