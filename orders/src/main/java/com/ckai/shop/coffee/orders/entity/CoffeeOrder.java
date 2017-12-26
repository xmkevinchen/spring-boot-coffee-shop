package com.ckai.shop.coffee.orders.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Data
@Document(collection = "orders")
public class CoffeeOrder {

    @Id
    private String orderId;
    private String beanOrigin;
    private String coffeeType;
    private CoffeeOrderState state;

    public enum CoffeeOrderState {
        PLACED, ACCEPTED, STARTED, FINISHED, DELIVERED, CANCELLED
    }

    public void place(String orderId, String beanOrigin, String coffeeType) {
        this.orderId = orderId;
        this.beanOrigin = beanOrigin;
        this.coffeeType = coffeeType;
        state = CoffeeOrderState.PLACED;
    }

    public void accept() {
        state = CoffeeOrderState.ACCEPTED;
    }

    public void cancel() {
        state = CoffeeOrderState.CANCELLED;
    }

    public void start() {
        state = CoffeeOrderState.STARTED;
    }

    public void finish() {
        state = CoffeeOrderState.FINISHED;
    }

    public void deliver() {
        state = CoffeeOrderState.DELIVERED;
    }

}
