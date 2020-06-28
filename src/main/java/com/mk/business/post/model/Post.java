package com.mk.business.post.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
*@date: 2020-5-15 16:56
*@author: Znw · Smile
*@Description: 
*/
@ApiModel(value="com-mk-business-post-model-Post")
@Table(name = "t_post")
public class Post implements Serializable {
    @Id
    @Column(name = "Post_Guid")
    @ApiModelProperty(value="")
    private String postGuid;

    @Column(name = "Post_Name")
    @ApiModelProperty(value="")
    private String postName;

    @Column(name = "Post_Type")
    @ApiModelProperty(value="")
    private String postType;

    @Column(name = "D_Order")
    @ApiModelProperty(value="")
    private BigDecimal dOrder;

    @Column(name = "`Valid`")
    @ApiModelProperty(value="")
    private Integer valid;

    @Column(name = "Modi_User")
    @ApiModelProperty(value="")
    private String modiUser;

    @Column(name = "Modi_Date")
    @ApiModelProperty(value="")
    private Date modiDate;

    @Column(name = "Remark")
    @ApiModelProperty(value="")
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * @return Post_Guid
     */
    public String getPostGuid() {
        return postGuid;
    }

    /**
     * @param postGuid
     */
    public void setPostGuid(String postGuid) {
        this.postGuid = postGuid;
    }

    /**
     * @return Post_Name
     */
    public String getPostName() {
        return postName;
    }

    /**
     * @param postName
     */
    public void setPostName(String postName) {
        this.postName = postName;
    }

    /**
     * @return Post_Type
     */
    public String getPostType() {
        return postType;
    }

    /**
     * @param postType
     */
    public void setPostType(String postType) {
        this.postType = postType;
    }

    /**
     * @return D_Order
     */
    public BigDecimal getdOrder() {
        return dOrder;
    }

    /**
     * @param dOrder
     */
    public void setdOrder(BigDecimal dOrder) {
        this.dOrder = dOrder;
    }

    /**
     * @return Valid
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * @param valid
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * @return Modi_User
     */
    public String getModiUser() {
        return modiUser;
    }

    /**
     * @param modiUser
     */
    public void setModiUser(String modiUser) {
        this.modiUser = modiUser;
    }

    /**
     * @return Modi_Date
     */
    public Date getModiDate() {
        return modiDate;
    }

    /**
     * @param modiDate
     */
    public void setModiDate(Date modiDate) {
        this.modiDate = modiDate;
    }

    /**
     * @return Remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}