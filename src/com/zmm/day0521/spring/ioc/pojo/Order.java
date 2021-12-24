package com.zmm.day0521.spring.ioc.pojo;

import java.math.BigDecimal;

/**
 * 描述:  订单详情
 *
 * @Name Order
 * @Author 900045
 * @Created by 2020/5/21 0021
 */
public class Order {

    private String orderId;
    private String userId;
    private String name;
    private BigDecimal amount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
