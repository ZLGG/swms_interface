package com.mk.business.bidexpert.model;

import com.mk.business.commentindex.model.CommentIndexPoint;

import java.util.List;

public class BidExpert {
    private String bidExpertGuid;
    private String projectGuid;
    private String bidItemGuid;
    private String expertGuid;
    private String certCode;
    private String name;
    private String unitName;
    private String phone;
    private String expertCategory;
    private Integer isTeamLeader;
    private Integer isOwnerRepresentative;
    private String interfaceCode;
    private String dataResource;

    private List<CommentIndexPoint> commentIndexPointList;

    public List<CommentIndexPoint> getCommentIndexPointList() {
        return commentIndexPointList;
    }

    public void setCommentIndexPointList(List<CommentIndexPoint> commentIndexPointList) {
        this.commentIndexPointList = commentIndexPointList;
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

    public String getBidExpertGuid() {
        return bidExpertGuid;
    }

    public void setBidExpertGuid(String bidExpertGuid) {
        this.bidExpertGuid = bidExpertGuid;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getBidItemGuid() {
        return bidItemGuid;
    }

    public void setBidItemGuid(String bidItemGuid) {
        this.bidItemGuid = bidItemGuid;
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

    public String getExpertCategory() {
        return expertCategory;
    }

    public void setExpertCategory(String expertCategory) {
        this.expertCategory = expertCategory;
    }

    public Integer getIsTeamLeader() {
        return isTeamLeader;
    }

    public void setIsTeamLeader(Integer isTeamLeader) {
        this.isTeamLeader = isTeamLeader;
    }

    public Integer getIsOwnerRepresentative() {
        return isOwnerRepresentative;
    }

    public void setIsOwnerRepresentative(Integer isOwnerRepresentative) {
        this.isOwnerRepresentative = isOwnerRepresentative;
    }
}
