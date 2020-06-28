package com.mk.business.optionlist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
*Description: 
*Created by zhangnengwei on 2020-4-8 15:30
*/
@ApiModel(value="com.mk.business.optionlist.model.Optionlist")
@Table(name = "t_d_optionlist")
public class Optionlist implements Serializable {
    @Id
    @Column(name = "Option_ID")
    @ApiModelProperty(value="null")
    private String optionId;

    @Column(name = "Option_Type_Guid")
    @ApiModelProperty(value="null")
    private String optionTypeGuid;

    @Column(name = "Code")
    @ApiModelProperty(value="null")
    private String code;

    @Column(name = "`Name`")
    @ApiModelProperty(value="null")
    private String name;

    @Column(name = "DOrder")
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
     * @return Option_ID
     */
    public String getOptionId() {
        return optionId;
    }

    /**
     * @param optionId
     */
    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    /**
     * @return Option_Type_Guid
     */
    public String getOptionTypeGuid() {
        return optionTypeGuid;
    }

    /**
     * @param optionTypeGuid
     */
    public void setOptionTypeGuid(String optionTypeGuid) {
        this.optionTypeGuid = optionTypeGuid;
    }

    /**
     * @return Code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
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