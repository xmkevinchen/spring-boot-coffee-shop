package com.ckai.shop.coffee.orders.events.order;

import com.ckai.shop.coffee.orders.events.CoffeeEvent;
import lombok.Data;

import java.time.Instant;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Data
public class CoffeeOrderPlacedEvent extends CoffeeEvent implements CoffeeOrderEvent {

    private String orderId;
    private String beanOrigin;
    private String coffeeType;

    public CoffeeOrderPlacedEvent() {
    }

    public CoffeeOrderPlacedEvent(String orderId, String beanOrigin, String coffeeType) {
        this.orderId = orderId;
        this.beanOrigin = beanOrigin;
        this.coffeeType = coffeeType;
    }

    public CoffeeOrderPlacedEvent(String orderId, String beanOrigin, String coffeeType, Instant timestamp) {
        super(timestamp);
        this.orderId = orderId;
        this.beanOrigin = beanOrigin;
        this.coffeeType = coffeeType;
    }
}
