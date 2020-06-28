package com.mk.business.commentindex.model;

import java.math.BigDecimal;
import java.util.List;

public class CommentIndex {
    private String commentIndexGuid;
    private String commentIndexPGuid;
    private String projectGuid;
    private String bidGuid;
    private String commentIndexName;
    private BigDecimal dOrder;
    private Integer priceType;
    private Integer includ;
    private Integer commentIndexType;
    private BigDecimal point;
    private Integer conformType;
    private String interfaceCode;
    private String dataResource;

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

    public String getCommentIndexGuid() {
        return commentIndexGuid;
    }

    public void setCommentIndexGuid(String commentIndexGuid) {
        this.commentIndexGuid = commentIndexGuid;
    }

    public String getCommentIndexPGuid() {
        return commentIndexPGuid;
    }

    public void setCommentIndexPGuid(String commentIndexPGuid) {
        this.commentIndexPGuid = commentIndexPGuid;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getBidGuid() {
        return bidGuid;
    }

    public void setBidGuid(String bidGuid) {
        this.bidGuid = bidGuid;
    }

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

    public Integer getCommentIndexType() {
        return commentIndexType;
    }

    public void setCommentIndexType(Integer commentIndexType) {
        this.commentIndexType = commentIndexType;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public Integer getConformType() {
        return conformType;
    }

    public void setConformType(Integer conformType) {
        this.conformType = conformType;
    }
}
