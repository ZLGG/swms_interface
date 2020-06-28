package com.mk.business.bizattachment.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

/**
*@date: 2020-5-7 11:25
*@author: Znw · Smile
*@Description: 
*/
@ApiModel(value="com-mk-business-bizattachment-model-Bizattachment")
@Table(name = "t_a_bizattachment")
public class Bizattachment implements Serializable {
    /**
     * 附件条目Guid
     */
    @Id
    @Column(name = "Attachment_Guid")
    @ApiModelProperty(value="附件条目Guid")
    private String attachmentGuid;

    /**
     * NoticeGuid
     */
    @Column(name = "Biz_Guid")
    @ApiModelProperty(value="NoticeGuid")
    private String bizGuid;

    /**
     * NoticeGuid
     */
    @Column(name = "Biz_Type")
    @ApiModelProperty(value="NoticeGuid")
    private String bizType;

    /**
     * 附件类型（选项）
     */
    @Column(name = "Attachment_Type")
    @ApiModelProperty(value="附件类型（选项）")
    private String attachmentType;

    /**
     * 文档名称
     */
    @Column(name = "File_Name")
    @ApiModelProperty(value="文档名称")
    private String fileName;

    /**
     * 文件路径
     */
    @Column(name = "File_Path")
    @ApiModelProperty(value="文件路径")
    private String filePath;

    private static final long serialVersionUID = 1L;

    /**
     * 获取附件条目Guid
     *
     * @return Attachment_Guid - 附件条目Guid
     */
    public String getAttachmentGuid() {
        return attachmentGuid;
    }

    /**
     * 设置附件条目Guid
     *
     * @param attachmentGuid 附件条目Guid
     */
    public void setAttachmentGuid(String attachmentGuid) {
        this.attachmentGuid = attachmentGuid;
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
     * 获取附件类型（选项）
     *
     * @return Attachment_Type - 附件类型（选项）
     */
    public String getAttachmentType() {
        return attachmentType;
    }

    /**
     * 设置附件类型（选项）
     *
     * @param attachmentType 附件类型（选项）
     */
    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    /**
     * 获取文档名称
     *
     * @return File_Name - 文档名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文档名称
     *
     * @param fileName 文档名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取文件路径
     *
     * @return File_Path - 文件路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置文件路径
     *
     * @param filePath 文件路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}