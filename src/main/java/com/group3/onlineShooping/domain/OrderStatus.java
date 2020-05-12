package com.group3.onlineShooping.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum OrderStatus {
    ORDERED(1),
    SHIPPED(3),
    TRANSIT(4),
    DELIVERED(5),
    CANCELD(6);

    Integer val;

    OrderStatus() {

    }

    OrderStatus(Integer val) {
        this.val = val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    private static OrderStatus[] list = OrderStatus.values();

    public static List<String> getOrderStatus(OrderStatus start, OrderStatus end) {
        if (end == null) {
            end = EndOrderStatus();
        }
        OrderStatus finalEnd = end;
        List<String> result = Arrays.stream(list)
                .filter(shippingStatus -> shippingStatus.val >= start.getVal() && shippingStatus.val <= finalEnd.getVal())
                .map(x -> x.toString()).collect(Collectors.toList());
        return result;
    }

    public static OrderStatus InitOrderStatus() {
        Optional<OrderStatus> result = Arrays.stream(list)
                .min((o1, o2) -> o1.getVal().compareTo(o2.getVal()));
        return result.get();
    }

    public static OrderStatus EndOrderStatus() {
        Optional<OrderStatus> result = Arrays.stream(list)
                .max((o1, o2) -> o1.getVal().compareTo(o2.getVal()));
        return result.get();
    }
}