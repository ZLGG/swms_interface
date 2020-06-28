package com.mk.business.notice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
*@date: 2020-4-28 15:04
*@author: Znw · Smile
*@Description:
*/
@ApiModel(value="com-mk-business-notice-model-Notice")
@Table(name = "t_a_notice")
public class Notice implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * NoticeGuid
     */
    @Id
    @Column(name = "Notice_Guid")
    @ApiModelProperty(value="NoticeGuid")
    private String noticeGuid;

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
     * 公告类型( 1:单一来源公示, 2:进口产品采购公示)
     */
    @Column(name = "Notice_Type")
    @ApiModelProperty(value="公告类型( 1:单一来源公示, 2:进口产品采购公示)")
    private String noticeType;

    @Column(name = "Publish_State")
    @ApiModelProperty(value="")
    private String publishState;

    @Column(name = "Publish_Date")
    @ApiModelProperty(value="")
    private Date publishDate;

    @Column(name = "Validity_Date")
    @ApiModelProperty(value="")
    private Date validityDate;

    /**
     * 公告编号
     */
    @Column(name = "Notice_Code")
    @ApiModelProperty(value="公告编号")
    private String noticeCode;

    /**
     * 公告名称
     */
    @Column(name = "Notice_Title")
    @ApiModelProperty(value="公告名称")
    private String noticeTitle;

    /**
     * 专家论证意见
     */
    @Column(name = "Suggestion")
    @ApiModelProperty(value="专家论证意见")
    private String suggestion;

    @Column(name = "Org_Guid")
    @ApiModelProperty(value="")
    private String orgGuid;

    @Column(name = "Region_Guid")
    @ApiModelProperty(value="")
    private String regionGuid;

    @Column(name = "Notice_Content")
    @ApiModelProperty(value="")
    private String noticeContent;

    @Column(name = "Biz_Interface_Code")
    @ApiModelProperty(value="")
    private String bizInterfaceCode;

    @Column(name = "Biz_Valid")
    @ApiModelProperty(value="")
    private BigDecimal bizValid;

    @Column(name = "Biz_Time_Stamp")
    @ApiModelProperty(value="")
    private Date bizTimeStamp;

    @Column(name = "Biz_Date")
    @ApiModelProperty(value="")
    private Date bizDate;

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="")
    private String interfaceCode;

    @Column(name = "Data_Resource")
    @ApiModelProperty(value="")
    private String dataResource;

    public String getNoticeGuid() {
        return noticeGuid;
    }

    public void setNoticeGuid(String noticeGuid) {
        this.noticeGuid = noticeGuid;
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

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getPublishState() {
        return publishState;
    }

    public void setPublishState(String publishState) {
        this.publishState = publishState;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public String getNoticeCode() {
        return noticeCode;
    }

    public void setNoticeCode(String noticeCode) {
        this.noticeCode = noticeCode;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getOrgGuid() {
        return orgGuid;
    }

    public void setOrgGuid(String orgGuid) {
        this.orgGuid = orgGuid;
    }

    public String getRegionGuid() {
        return regionGuid;
    }

    public void setRegionGuid(String regionGuid) {
        this.regionGuid = regionGuid;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getBizInterfaceCode() {
        return bizInterfaceCode;
    }

    public void setBizInterfaceCode(String bizInterfaceCode) {
        this.bizInterfaceCode = bizInterfaceCode;
    }

    public BigDecimal getBizValid() {
        return bizValid;
    }

    public void setBizValid(BigDecimal bizValid) {
        this.bizValid = bizValid;
    }

    public Date getBizTimeStamp() {
        return bizTimeStamp;
    }

    public void setBizTimeStamp(Date bizTimeStamp) {
        this.bizTimeStamp = bizTimeStamp;
    }

    public Date getBizDate() {
        return bizDate;
    }

    public void setBizDate(Date bizDate) {
        this.bizDate = bizDate;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getDataResource() {
        return dataResource;
    }

    public void setDataResource(String dataResource) {
        this.dataResource = dataResource;
    }
}
