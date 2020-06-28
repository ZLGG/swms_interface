package com.mk.business.audithistory.param;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @date: 2020-5-14 9:51
 * @author: Znw · Smile
 * @Description:待校验参数
 */
public class AudithistoryCheckoutParam implements Serializable {

    private static final long serialVersionUID = -4415866661073136364L;
    @Id
    @Column(name = "AuditHistory_Guid")
    @ApiModelProperty(value="")
    private String audithistoryGuid;

    @Column(name = "Biz_Guid")
    @ApiModelProperty(value="")
    private String bizGuid;

    @Column(name = "Biz_Type")
    @ApiModelProperty(value="")
    private String bizType;

    @Column(name = "Task_Name")
    @ApiModelProperty(value="")
    private String taskName;

    @Column(name = "Excute_Org_Guid")
    @ApiModelProperty(value="")
    private String excuteOrgGuid;

    @Column(name = "Excute_Org_Name")
    @ApiModelProperty(value="")
    private String excuteOrgName;

    @Column(name = "Excute_Org_Type")
    @ApiModelProperty(value="")
    private Short excuteOrgType;

    @Column(name = "Post_Guid")
    @ApiModelProperty(value="")
    private String postGuid;

    @Column(name = "Post_Name")
    @ApiModelProperty(value="")
    private String postName;

    @Column(name = "Excute_User_Guid")
    @ApiModelProperty(value="")
    private String excuteUserGuid;

    @Column(name = "Excute_User_Name")
    @ApiModelProperty(value="")
    private String excuteUserName;

    public String getAudithistoryGuid() {
        return audithistoryGuid;
    }

    public void setAudithistoryGuid(String audithistoryGuid) {
        this.audithistoryGuid = audithistoryGuid;
    }

    public String getBizGuid() {
        return bizGuid;
    }

    public void setBizGuid(String bizGuid) {
        this.bizGuid = bizGuid;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getExcuteOrgGuid() {
        return excuteOrgGuid;
    }

    public void setExcuteOrgGuid(String excuteOrgGuid) {
        this.excuteOrgGuid = excuteOrgGuid;
    }

    public String getExcuteOrgName() {
        return excuteOrgName;
    }

    public void setExcuteOrgName(String excuteOrgName) {
        this.excuteOrgName = excuteOrgName;
    }

    public Short getExcuteOrgType() {
        return excuteOrgType;
    }

    public void setExcuteOrgType(Short excuteOrgType) {
        this.excuteOrgType = excuteOrgType;
    }

    public String getPostGuid() {
        return postGuid;
    }

    public void setPostGuid(String postGuid) {
        this.postGuid = postGuid;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getExcuteUserGuid() {
        return excuteUserGuid;
    }

    public void setExcuteUserGuid(String excuteUserGuid) {
        this.excuteUserGuid = excuteUserGuid;
    }

    public String getExcuteUserName() {
        return excuteUserName;
    }

    public void setExcuteUserName(String excuteUserName) {
        this.excuteUserName = excuteUserName;
    }
}
