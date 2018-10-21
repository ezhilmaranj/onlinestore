package com.ezhilsys.onlinestore.model;

import java.math.BigDecimal;
import java.util.List;

public class Bill {
    private String id;

    private Customer customer;

    private List<Item> lineItems;

    private BigDecimal totalAmount;

    private BigDecimal discountAmount;

    private BigDecimal netAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<Item> lineItems) {
        this.lineItems = lineItems;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

}
