package com.mk.business.commentresult.model;

import java.util.List;

public class CommentResult {
    private String commentResultGuid;
    private String projectGuid;
    private String bidItemGuid;
    private Integer calculateType;
    private Integer cutCeilFloor;
    private Integer isSucceed;
    private Integer purIsSucceed;
    private String failReason;
    private String purFailReason;

    private List<CommentResultDetail> commentResultDetailList;

    public List<CommentResultDetail> getCommentResultDetailList() {
        return commentResultDetailList;
    }

    public void setCommentResultDetailList(List<CommentResultDetail> commentResultDetailList) {
        this.commentResultDetailList = commentResultDetailList;
    }

    public String getCommentResultGuid() {
        return commentResultGuid;
    }

    public void setCommentResultGuid(String commentResultGuid) {
        this.commentResultGuid = commentResultGuid;
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

    public Integer getCalculateType() {
        return calculateType;
    }

    public void setCalculateType(Integer calculateType) {
        this.calculateType = calculateType;
    }

    public Integer getCutCeilFloor() {
        return cutCeilFloor;
    }

    public void setCutCeilFloor(Integer cutCeilFloor) {
        this.cutCeilFloor = cutCeilFloor;
    }

    public Integer getIsSucceed() {
        return isSucceed;
    }

    public void setIsSucceed(Integer isSucceed) {
        this.isSucceed = isSucceed;
    }

    public Integer getPurIsSucceed() {
        return purIsSucceed;
    }

    public void setPurIsSucceed(Integer purIsSucceed) {
        this.purIsSucceed = purIsSucceed;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getPurFailReason() {
        return purFailReason;
    }

    public void setPurFailReason(String purFailReason) {
        this.purFailReason = purFailReason;
    }
}
