package com.mk.business.region.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

/**
*Description: 
*Created by zhangnengwei on 2020-4-8 14:23
*/
@ApiModel(value="com.mk.business.region.model.Region")
@Table(name = "t_d_region")
public class Region implements Serializable {
    @Id
    @Column(name = "Region_Guid")
    @ApiModelProperty(value="null")
    private String regionGuid;

    @Column(name = "Region_P_Guid")
    @ApiModelProperty(value="null")
    private String regionPGuid;

    @Column(name = "Region_Name")
    @ApiModelProperty(value="null")
    private String regionName;

    @Column(name = "Short_Name")
    @ApiModelProperty(value="null")
    private String shortName;

    @Column(name = "Region_Code")
    @ApiModelProperty(value="null")
    private String regionCode;

    @Column(name = "`Valid`")
    @ApiModelProperty(value="null")
    private Short valid;

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="null")
    private String interfaceCode;

    private static final long serialVersionUID = 1L;

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
     * @return Region_P_Guid
     */
    public String getRegionPGuid() {
        return regionPGuid;
    }

    /**
     * @param regionPGuid
     */
    public void setRegionPGuid(String regionPGuid) {
        this.regionPGuid = regionPGuid;
    }

    /**
     * @return Region_Name
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * @param regionName
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
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
     * @return Region_Code
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * @param regionCode
     */
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
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