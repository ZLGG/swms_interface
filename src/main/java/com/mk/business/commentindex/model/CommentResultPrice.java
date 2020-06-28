package com.mk.business.commentindex.model;

import java.math.BigDecimal;

public class CommentResultPrice {
    private String commentResultPriceGuid;
    private String commentResultDetailGuid;
    private String commentIndexGuid;
    private String commentIndexName;
    private Integer priceType;
    private Integer includ;
    private BigDecimal lastPrice;
    private BigDecimal priceValue;

    public String getCommentResultPriceGuid() {
        return commentResultPriceGuid;
    }

    public void setCommentResultPriceGuid(String commentResultPriceGuid) {
        this.commentResultPriceGuid = commentResultPriceGuid;
    }

    public String getCommentResultDetailGuid() {
        return commentResultDetailGuid;
    }

    public void setCommentResultDetailGuid(String commentResultDetailGuid) {
        this.commentResultDetailGuid = commentResultDetailGuid;
    }

    public String getCommentIndexGuid() {
        return commentIndexGuid;
    }

    public void setCommentIndexGuid(String commentIndexGuid) {
        this.commentIndexGuid = commentIndexGuid;
    }

    public String getCommentIndexName() {
        return commentIndexName;
    }

    public void setCommentIndexName(String commentIndexName) {
        this.commentIndexName = commentIndexName;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public Integer getInclud() {
        return includ;
    }

    public void setInclud(Integer includ) {
        this.includ = includ;
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
}
