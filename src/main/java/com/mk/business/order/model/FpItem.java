package com.mk.business.order.model;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * t_fp_item
 * @author 
 */
public class FpItem implements Serializable {
    private String itemGuid;

    private String orderId;

    private String categoryName;

    private String productName;

    private BigDecimal unitPrice;

    private Integer quantity;

    private static final long serialVersionUID = 1L;

    public String getItemGuid() {
        return itemGuid;
    }

    public void setItemGuid(String itemGuid) {
        this.itemGuid = itemGuid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}