package com.mk.business.location.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

/**
*Description: 
*Created by zhangnengwei on 2020-4-8 14:03
*/
@ApiModel(value="com.mk.business.location.model.Location")
@Table(name = "t_d_location")
public class Location implements Serializable {
    /**
     * 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    @Id
    @Column(name = "Location_Guid")
    @ApiModelProperty(value="供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空")
    private String locationGuid;

    /**
     * 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    @Column(name = "Location_P_Guid")
    @ApiModelProperty(value="供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空")
    private String locationPGuid;

    /**
     * 供应商名称
     */
    @Column(name = "Location_Name")
    @ApiModelProperty(value="供应商名称")
    private String locationName;

    /**
     * 供应商名称
     */
    @Column(name = "Location_Path_Name")
    @ApiModelProperty(value="供应商名称")
    private String locationPathName;

    /**
     * 级次
     */
    @Column(name = "`level`")
    @ApiModelProperty(value="级次")
    private Short level;

    @Column(name = "Province_Guid")
    @ApiModelProperty(value="null")
    private String provinceGuid;

    @Column(name = "City_Guid")
    @ApiModelProperty(value="null")
    private String cityGuid;

    @Column(name = "District_Guid")
    @ApiModelProperty(value="null")
    private String districtGuid;

    @Column(name = "Street_Guid")
    @ApiModelProperty(value="null")
    private String streetGuid;

    @Column(name = "`Valid`")
    @ApiModelProperty(value="null")
    private Short valid;

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="null")
    private String interfaceCode;

    private static final long serialVersionUID = 1L;

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
     * 获取供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     *
     * @return Location_P_Guid - 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    public String getLocationPGuid() {
        return locationPGuid;
    }

    /**
     * 设置供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     *
     * @param locationPGuid 供应商Guid(付款供应商Guid)老系统的供应商可能没入库所以为空,界面控制必须非空
     */
    public void setLocationPGuid(String locationPGuid) {
        this.locationPGuid = locationPGuid;
    }

    /**
     * 获取供应商名称
     *
     * @return Location_Name - 供应商名称
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * 设置供应商名称
     *
     * @param locationName 供应商名称
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * 获取供应商名称
     *
     * @return Location_Path_Name - 供应商名称
     */
    public String getLocationPathName() {
        return locationPathName;
    }

    /**
     * 设置供应商名称
     *
     * @param locationPathName 供应商名称
     */
    public void setLocationPathName(String locationPathName) {
        this.locationPathName = locationPathName;
    }

    /**
     * 获取级次
     *
     * @return level - 级次
     */
    public Short getLevel() {
        return level;
    }

    /**
     * 设置级次
     *
     * @param level 级次
     */
    public void setLevel(Short level) {
        this.level = level;
    }

    /**
     * @return Province_Guid
     */
    public String getProvinceGuid() {
        return provinceGuid;
    }

    /**
     * @param provinceGuid
     */
    public void setProvinceGuid(String provinceGuid) {
        this.provinceGuid = provinceGuid;
    }

    /**
     * @return City_Guid
     */
    public String getCityGuid() {
        return cityGuid;
    }

    /**
     * @param cityGuid
     */
    public void setCityGuid(String cityGuid) {
        this.cityGuid = cityGuid;
    }

    /**
     * @return District_Guid
     */
    public String getDistrictGuid() {
        return districtGuid;
    }

    /**
     * @param districtGuid
     */
    public void setDistrictGuid(String districtGuid) {
        this.districtGuid = districtGuid;
    }

    /**
     * @return Street_Guid
     */
    public String getStreetGuid() {
        return streetGuid;
    }

    /**
     * @param streetGuid
     */
    public void setStreetGuid(String streetGuid) {
        this.streetGuid = streetGuid;
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