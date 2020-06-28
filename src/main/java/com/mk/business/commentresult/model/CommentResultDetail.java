package com.mk.business.commentresult.model;

import com.mk.business.commentindex.model.CommentResultPrice;

import java.math.BigDecimal;
import java.util.List;

public class CommentResultDetail {
    private String commentResultDetailGuid;
    private String commentResultGuid;
    private String responseGuid;
    private Integer isHit;
    private Integer sort;
    private BigDecimal lastPrice;
    private BigDecimal priceValue;
    private BigDecimal creditValue;
    private BigDecimal expertValue;
    private BigDecimal sumValue;
    private Integer isConform;

    private List<CommentResultPrice> commentResultPriceList;

    public List<CommentResultPrice> getCommentResultPriceList() {
        return commentResultPriceList;
    }

    public void setCommentResultPriceList(List<CommentResultPrice> commentResultPriceList) {
        this.commentResultPriceList = commentResultPriceList;
    }

    public String getCommentResultDetailGuid() {
        return commentResultDetailGuid;
    }

    public void setCommentResultDetailGuid(String commentResultDetailGuid) {
        this.commentResultDetailGuid = commentResultDetailGuid;
    }

    public String getCommentResultGuid() {
        return commentResultGuid;
    }

    public void setCommentResultGuid(String commentResultGuid) {
        this.commentResultGuid = commentResultGuid;
    }

    public String getResponseGuid() {
        return responseGuid;
    }

    public void setResponseGuid(String responseGuid) {
        this.responseGuid = responseGuid;
    }

    public Integer getIsHit() {
        return isHit;
    }

    public void setIsHit(Integer isHit) {
        this.isHit = isHit;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public BigDecimal getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(BigDecimal priceValue) {
        this.priceValue = priceValue;
    }

    public BigDecimal getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(BigDecimal creditValue) {
        this.creditValue = creditValue;
    }

    public BigDecimal getExpertValue() {
        return expertValue;
    }

    public void setExpertValue(BigDecimal expertValue) {
        this.expertValue = expertValue;
    }

    public BigDecimal getSumValue() {
        return sumValue;
    }

    public void setSumValue(BigDecimal sumValue) {
        this.sumValue = sumValue;
    }

    public Integer getIsConform() {
        return isConform;
    }

    public void setIsConform(Integer isConform) {
        this.isConform = isConform;
    }
}
