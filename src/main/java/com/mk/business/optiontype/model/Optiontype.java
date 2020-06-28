package com.mk.business.optiontype.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

/**
*Description: 
*Created by zhangnengwei on 2020-4-8 15:26
*/
@ApiModel(value="com.mk.business.optiontype.model.Optiontype")
@Table(name = "t_d_optiontype")
public class Optiontype implements Serializable {
    @Id
    @Column(name = "Option_Type_Guid")
    @ApiModelProperty(value="null")
    private String optionTypeGuid;

    @Column(name = "Code")
    @ApiModelProperty(value="null")
    private String code;

    @Column(name = "`Name`")
    @ApiModelProperty(value="null")
    private String name;

    @Column(name = "`Valid`")
    @ApiModelProperty(value="null")
    private Short valid;

    private static final long serialVersionUID = 1L;

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