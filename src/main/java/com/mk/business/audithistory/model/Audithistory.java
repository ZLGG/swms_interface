package com.mk.business.audithistory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
*@date: 2020-4-27 15:27
*@author: Znw · Smile
*@Description:
*/
@ApiModel(value="com-mk-business-audithistory-model-Audithistory")
@Table(name = "t_a_audithistory")
public class Audithistory implements Serializable {

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

    @Column(name = "Excute_Time")
    @ApiModelProperty(value="")
    private Date excuteTime;

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

    private static final long serialVersionUID = 1L;

    /**
     * 获取NoticeGuid
     *
     * @return AuditHistory_Guid - NoticeGuid
     */
    public String getAudithistoryGuid() {
        return audithistoryGuid;
    }

    /**
     * 设置NoticeGuid
     *
     * @param audithistoryGuid NoticeGuid
     */
    public void setAudithistoryGuid(String audithistoryGuid) {
        this.audithistoryGuid = audithistoryGuid;
    }

    /**
     * 获取NoticeGuid
     *
     * @return Biz_Guid - NoticeGuid
     */
    public String getBizGuid() {
        return bizGuid;
    }

    /**
     * 设置NoticeGuid
     *
     * @param bizGuid NoticeGuid
     */
    public void setBizGuid(String bizGuid) {
        this.bizGuid = bizGuid;
    }

    /**
     * 获取NoticeGuid
     *
     * @return Biz_Type - NoticeGuid
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * 设置NoticeGuid
     *
     * @param bizType NoticeGuid
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**
     * @return Excute_Time
     */
    public Date getExcuteTime() {
        return excuteTime;
    }

    /**
     * @param excuteTime
     */
    public void setExcuteTime(Date excuteTime) {
        this.excuteTime = excuteTime;
    }

    /**
     * @return Task_Name
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return Excute_Org_Guid
     */
    public String getExcuteOrgGuid() {
        return excuteOrgGuid;
    }

    /**
     * @param excuteOrgGuid
     */
    public void setExcuteOrgGuid(String excuteOrgGuid) {
        this.excuteOrgGuid = excuteOrgGuid;
    }

    /**
     * @return Excute_Org_Name
     */
    public String getExcuteOrgName() {
        return excuteOrgName;
    }

    /**
     * @param excuteOrgName
     */
    public void setExcuteOrgName(String excuteOrgName) {
        this.excuteOrgName = excuteOrgName;
    }

    /**
     * @return Excute_Org_Type
     */
    public Short getExcuteOrgType() {
        return excuteOrgType;
    }

    /**
     * @param excuteOrgType
     */
    public void setExcuteOrgType(Short excuteOrgType) {
        this.excuteOrgType = excuteOrgType;
    }

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
     * @return Excute_User_Guid
     */
    public String getExcuteUserGuid() {
        return excuteUserGuid;
    }

    /**
     * @param excuteUserGuid
     */
    public void setExcuteUserGuid(String excuteUserGuid) {
        this.excuteUserGuid = excuteUserGuid;
    }

    /**
     * @return Excute_User_Name
     */
    public String getExcuteUserName() {
        return excuteUserName;
    }

    /**
     * @param excuteUserName
     */
    public void setExcuteUserName(String excuteUserName) {
        this.excuteUserName = excuteUserName;
    }
}
