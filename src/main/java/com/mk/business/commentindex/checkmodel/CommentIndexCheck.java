package com.mk.business.commentindex.checkmodel;

import java.math.BigDecimal;

public class CommentIndexCheck {
    private String commentIndexName;
    private BigDecimal dOrder;
    private Integer priceType;
    private Integer includ;
    private String interfaceCode;
    private String dataResource;

    public String getCommentIndexName() {
        return commentIndexName;
    }

    public void setCommentIndexName(String commentIndexName) {
        this.commentIndexName = commentIndexName;
    }

    public BigDecimal getdOrder() {
        return dOrder;
    }

    public void setdOrder(BigDecimal dOrder) {
        this.dOrder = dOrder;
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
