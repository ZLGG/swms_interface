package com.mk.business.expert.model;

import java.io.Serializable;
import java.util.Date;

/**
 * t_d_expert
 * @author 
 */
public class Expert implements Serializable {
    private String expertGuid;

    private String certCode;

    private String name;

    private String unitName;

    private String phone;

    private Short sex;

    private Date birthday;

    private Short politics;

    private Integer purActivity;

    private Short culture;

    private Date titleDate;

    private Short title;

    private Date workDate;

    private Short expertChannel;

    private Short unitType;

    private String address;

    private String postCode;

    private Date registTime;

    private Date checkPassDate;

    private Date noticeDate;

    private Date approvedDate;

    private Date examPassDate;

    private Date inspectionDate;

    private Date pauseDate;

    private Date recoverDate;

    private String pauseReason;

    private Date quitDate;

    private String quitReason;

    private Integer bizValid;

    private Date bizDate;

    private Date bizTimeStamp;

    private String interfaceCode;

    private String dataResource;

    private static final long serialVersionUID = 1L;

    public Integer getPurActivity() {
        return purActivity;
    }

    public void setPurActivity(Integer purActivity) {
        this.purActivity = purActivity;
    }

    public String getExpertGuid() {
        return expertGuid;
    }

    public void setExpertGuid(String expertGuid) {
        this.expertGuid = expertGuid;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Short getPolitics() {
        return politics;
    }

    public void setPolitics(Short politics) {
        this.politics = politics;
    }

    public Short getCulture() {
        return culture;
    }

    public void setCulture(Short culture) {
        this.culture = culture;
    }

    public Date getTitleDate() {
        return titleDate;
    }

    public void setTitleDate(Date titleDate) {
        this.titleDate = titleDate;
    }

    public Short getTitle() {
        return title;
    }

    public void setTitle(Short title) {
        this.title = title;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Short getExpertChannel() {
        return expertChannel;
    }

    public void setExpertChannel(Short expertChannel) {
        this.expertChannel = expertChannel;
    }

    public Short getUnitType() {
        return unitType;
    }

    public void setUnitType(Short unitType) {
        this.unitType = unitType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Date getCheckPassDate() {
        return checkPassDate;
    }

    public void setCheckPassDate(Date checkPassDate) {
        this.checkPassDate = checkPassDate;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Date getExamPassDate() {
        return examPassDate;
    }

    public void setExamPassDate(Date examPassDate) {
        this.examPassDate = examPassDate;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public Date getPauseDate() {
        return pauseDate;
    }

    public void setPauseDate(Date pauseDate) {
        this.pauseDate = pauseDate;
    }

    public Date getRecoverDate() {
        return recoverDate;
    }

    public void setRecoverDate(Date recoverDate) {
        this.recoverDate = recoverDate;
    }

    public String getPauseReason() {
        return pauseReason;
    }

    public void setPauseReason(String pauseReason) {
        this.pauseReason = pauseReason;
    }

    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }

    public String getQuitReason() {
        return quitReason;
    }

    public void setQuitReason(String quitReason) {
        this.quitReason = quitReason;
    }

    public Integer getBizValid() {
        return bizValid;
    }

    public void setBizValid(Integer bizValid) {
        this.bizValid = bizValid;
    }

    public Date getBizDate() {
        return bizDate;
    }

    public void setBizDate(Date bizDate) {
        this.bizDate = bizDate;
    }

    public Date getBizTimeStamp() {
        return bizTimeStamp;
    }

    public void setBizTimeStamp(Date bizTimeStamp) {
        this.bizTimeStamp = bizTimeStamp;
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