package com.xdclass.entity;

import java.io.Serializable;

/**
 * @author Obsession.yin
 * @date 2020/3/16
 */
public class Order implements Serializable{

    private String orderName;

    private Integer orderId;

    public Order(String orderName, Integer orderId) {
        this.orderName = orderName;
        this.orderId = orderId;
    }



    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
