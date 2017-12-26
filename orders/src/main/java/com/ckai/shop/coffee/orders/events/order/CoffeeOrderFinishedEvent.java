package com.ckai.shop.coffee.orders.events.order;

import com.ckai.shop.coffee.orders.events.CoffeeEvent;
import lombok.Data;

import java.time.Instant;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Data
public class CoffeeOrderFinishedEvent extends CoffeeEvent implements CoffeeOrderEvent {

    private String orderId;

    public CoffeeOrderFinishedEvent() {
    }

    public CoffeeOrderFinishedEvent(String orderId) {
        this.orderId = orderId;
    }

    public CoffeeOrderFinishedEvent(String orderId, Instant timestamp) {
        super(timestamp);
        this.orderId = orderId;
    }
}
