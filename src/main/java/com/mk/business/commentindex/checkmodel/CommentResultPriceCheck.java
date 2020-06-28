package com.mk.business.commentindex.checkmodel;

import java.math.BigDecimal;

public class CommentResultPriceCheck {
    private String commentIndexName;
    private Integer priceType;
    private Integer includ;
    private BigDecimal lastPrice;

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
}
