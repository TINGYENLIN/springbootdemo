package com.example.demo.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public class OrderRequest {

    @NotNull
    private Integer orderId;

    @NotNull
    private Integer memberId;

    @NotNull
    private String memberName;

    @NotNull
    private String memberPhone;

    @NotNull
    private Integer productId;

    @NotNull
    private String plan;

    @NotNull
    private Integer price;

    @NotNull
    private Integer employeeId;

    @NotNull
    private String employeeName;

    @NotNull
    private String memberCreditcard;

    private Date orderDate;

    private String status;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getMemberCreditcard() {
        return memberCreditcard;
    }

    public void setMemberCreditcard(String memberCreditcard) {
        this.memberCreditcard = memberCreditcard;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
