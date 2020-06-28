package com.mk.business.resource.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
*Description: 
*Created by zhangnengwei on 2020-4-8 16:30
*/
@ApiModel(value="com.mk.business.resource.model.Resource")
@Table(name = "t_d_resource")
public class Resource implements Serializable {
    @Id
    @Column(name = "Resource_Guid")
    @ApiModelProperty(value="null")
    private String resourceGuid;

    @Column(name = "Region_Guid")
    @ApiModelProperty(value="null")
    private String regionGuid;

    @Column(name = "`Year`")
    @ApiModelProperty(value="null")
    private Short year;

    @Column(name = "Resource_Name")
    @ApiModelProperty(value="null")
    private String resourceName;

    @Column(name = "Dorder")
    @ApiModelProperty(value="null")
    private BigDecimal dorder;

    @Column(name = "`Valid`")
    @ApiModelProperty(value="null")
    private Short valid;

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="null")
    private String interfaceCode;

    private static final long serialVersionUID = 1L;

    /**
     * @return Resource_Guid
     */
    public String getResourceGuid() {
        return resourceGuid;
    }

    /**
     * @param resourceGuid
     */
    public void setResourceGuid(String resourceGuid) {
        this.resourceGuid = resourceGuid;
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
     * @return Resource_Name
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * @return Dorder
     */
    public BigDecimal getDorder() {
        return dorder;
    }

    /**
     * @param dorder
     */
    public void setDorder(BigDecimal dorder) {
        this.dorder = dorder;
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