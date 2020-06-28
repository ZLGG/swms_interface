package com.mk.business.purcatalog.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

/**
*Description: 
*Created by zhangnengwei on 2020-4-8 15:02
*/
@ApiModel(value="com.mk.business.purcatalog.model.Purcatalog")
@Table(name = "t_d_purcatalog")
public class Purcatalog implements Serializable {
    @Id
    @Column(name = "PurCatalog_Guid")
    @ApiModelProperty(value="null")
    private String purcatalogGuid;

    @Column(name = "PurCatalog_P_Guid")
    @ApiModelProperty(value="null")
    private String purcatalogPGuid;

    @Column(name = "`Year`")
    @ApiModelProperty(value="null")
    private Short year;

    @Column(name = "Region_Guid")
    @ApiModelProperty(value="null")
    private String regionGuid;

    @Column(name = "`Name`")
    @ApiModelProperty(value="null")
    private String name;

    @Column(name = "PurCatalog_Code")
    @ApiModelProperty(value="null")
    private String purcatalogCode;

    @Column(name = "Kind")
    @ApiModelProperty(value="null")
    private String kind;

    @Column(name = "PurCatalog_Type")
    @ApiModelProperty(value="null")
    private String purcatalogType;

    @Column(name = "`Valid`")
    @ApiModelProperty(value="null")
    private Short valid;

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="null")
    private String interfaceCode;

    private static final long serialVersionUID = 1L;

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
     * @return PurCatalog_P_Guid
     */
    public String getPurcatalogPGuid() {
        return purcatalogPGuid;
    }

    /**
     * @param purcatalogPGuid
     */
    public void setPurcatalogPGuid(String purcatalogPGuid) {
        this.purcatalogPGuid = purcatalogPGuid;
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
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return PurCatalog_Code
     */
    public String getPurcatalogCode() {
        return purcatalogCode;
    }

    /**
     * @param purcatalogCode
     */
    public void setPurcatalogCode(String purcatalogCode) {
        this.purcatalogCode = purcatalogCode;
    }

    /**
     * @return Kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind
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