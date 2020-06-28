package com.mk.business.notice.param;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @date: 2020-5-15 12:59
 * @author: Znw · Smile
 * @Description: 公示待校验参数
 */
public class NoticeCheckoutParam implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Column(name = "Org_Guid")
    @ApiModelProperty(value="")
    private String orgGuid;

    @Column(name = "Region_Guid")
    @ApiModelProperty(value="")
    private String regionGuid;

    @Column(name = "Biz_Valid")
    @ApiModelProperty(value="")
    private BigDecimal bizValid;

    @Column(name = "Interface_Code")
    @ApiModelProperty(value="")
    private String interfaceCode;

    @Column(name = "Data_Resource")
    @ApiModelProperty(value="")
    private String dataResource;

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

    public BigDecimal getBizValid() {
        return bizValid;
    }

    public void setBizValid(BigDecimal bizValid) {
        this.bizValid = bizValid;
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
