package com.ckai.shop.coffee.orders.events;

import lombok.Data;

import java.time.Instant;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Data
public abstract class CoffeeEvent {

    private final Instant timestamp;

    protected CoffeeEvent() {
        timestamp = Instant.now();
    }

    protected CoffeeEvent(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
