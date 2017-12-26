package com.ckai.shop.coffee.orders.producer;

import lombok.Data;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Data
public class CoffeeEventMessage {

    private String eventType;
    private String message;

    public CoffeeEventMessage() {
    }

    public CoffeeEventMessage(String eventType, String message) {
        this.eventType = eventType;
        this.message = message;
    }
}
