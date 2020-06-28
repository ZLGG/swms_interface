package com.mk.business.commentindex.model;

import java.math.BigDecimal;

public class CommentIndexPoint {
    private String commentIndexPointGuid;
    private String responseGuid;
    private String commentIndexGuid;
    private String bidExpertGuid;
    private BigDecimal point;
    private Integer reviewResult;

    public String getCommentIndexPointGuid() {
        return commentIndexPointGuid;
    }

    public void setCommentIndexPointGuid(String commentIndexPointGuid) {
        this.commentIndexPointGuid = commentIndexPointGuid;
    }

    public String getResponseGuid() {
        return responseGuid;
    }

    public void setResponseGuid(String responseGuid) {
        this.responseGuid = responseGuid;
    }

    public String getCommentIndexGuid() {
        return commentIndexGuid;
    }

    public void setCommentIndexGuid(String commentIndexGuid) {
        this.commentIndexGuid = commentIndexGuid;
    }

    public String getBidExpertGuid() {
        return bidExpertGuid;
    }

    public void setBidExpertGuid(String bidExpertGuid) {
        this.bidExpertGuid = bidExpertGuid;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public Integer getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(Integer reviewResult) {
        this.reviewResult = reviewResult;
    }
}
