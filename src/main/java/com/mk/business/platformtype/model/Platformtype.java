package com.mk.business.platformtype.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
*Description: 
*Created by zhangnengwei on 2020-4-8 15:35
*/
@ApiModel(value="com.mk.business.platformtype.model.Platformtype")
@Table(name = "t_d_platformtype")
public class Platformtype implements Serializable {
    @Id
    @Column(name = "Platform_Type_Guid")
    @ApiModelProperty(value="null")
    private String platformTypeGuid;

    @Column(name = "Platform_Type_Name")
    @ApiModelProperty(value="null")
    private String platformTypeName;

    @Column(name = "DOrder")
    @ApiModelProperty(value="null")
    private BigDecimal dorder;

    @Column(name = "`Valid`")
    @ApiModelProperty(value="null")
    private Short valid;

    private static final long serialVersionUID = 1L;

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
     * @return Platform_Type_Name
     */
    public String getPlatformTypeName() {
        return platformTypeName;
    }

    /**
     * @param platformTypeName
     */
    public void setPlatformTypeName(String platformTypeName) {
        this.platformTypeName = platformTypeName;
    }

    /**
     * @return DOrder
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
}