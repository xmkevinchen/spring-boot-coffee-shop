package com.ckai.shop.coffee.orders.events.order;

import com.ckai.shop.coffee.orders.events.CoffeeEvent;
import lombok.Data;

import java.time.Instant;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Data
public class CoffeeOrderCancelledEvent extends CoffeeEvent implements CoffeeOrderEvent {

    private String orderId;
    private String reason;

    public CoffeeOrderCancelledEvent() {
    }

    public CoffeeOrderCancelledEvent(String orderId, String reason) {
        this.orderId = orderId;
        this.reason = reason;
    }

    public CoffeeOrderCancelledEvent(String orderId, String reason, Instant timestamp) {
        super(timestamp);
        this.orderId = orderId;
        this.reason = reason;
    }
}
