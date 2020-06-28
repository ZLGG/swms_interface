package com.mk.business.agent.model;

import java.io.Serializable;
import java.util.Date;

/**
 * t_d_agent
 * @author 
 */
public class Agent implements Serializable {
    /**
     * （×）代理机构Guid
     */
    private String agentGuid;

    /**
     * 工作单位
     */
    private String agentCode;

    /**
     * 供应商名称
     */
    private String agentName;

    private Short agentType;

    private String address;

    private String linkman;

    private String telphone;

    private String fax;

    private String postcode;

    private Date pauseDate;

    private Date recoverDate;

    private String pauseReason;

    private Integer bizValid;

    private Integer purActivity;

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

    public String getAgentGuid() {
        return agentGuid;
    }

    public void setAgentGuid(String agentGuid) {
        this.agentGuid = agentGuid;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Short getAgentType() {
        return agentType;
    }

    public void setAgentType(Short agentType) {
        this.agentType = agentType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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