package com.beacon.model.builders;

import com.beacon.model.Mobile;
import com.beacon.model.order.Order;
import com.beacon.model.order.Task;

import java.time.LocalDate;

public class OrderBuilder {

    private static OrderBuilder INSTANCE;
    
    private Long orderId;
    private Mobile mobile;
    private String mobileId;
    private Long shopId;
    private Double price;
    private Integer count;
    private LocalDate registeredDate;
    private Task task;

    public static OrderBuilder create() {
        INSTANCE = new OrderBuilder();
        return INSTANCE;
    }

    public OrderBuilder withOrderId(Long orderId) {
        this.orderId = orderId;
        return INSTANCE;
    }

    public OrderBuilder withMobile(Mobile mobile) {
        this.mobile = mobile;
        return INSTANCE;
    }

    public OrderBuilder withMobileId(String mobileId) {
        this.mobileId = mobileId;
        return INSTANCE;
    }

    public OrderBuilder withShopId(Long shopId) {
        this.shopId = shopId;
        return INSTANCE;
    }

    public OrderBuilder withPrice(Double price) {
        this.price = price;
        return INSTANCE;
    }

    public OrderBuilder withCount(Integer count) {
        this.count = count;
        return INSTANCE;
    }

    public OrderBuilder withRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
        return INSTANCE;
    }

    public OrderBuilder withTask(Task task) {
        this.task = task;
        return INSTANCE;
    }

    public Order build() {
        return new Order(orderId, mobile, mobileId, shopId, price, count, registeredDate, task);
    }
}
