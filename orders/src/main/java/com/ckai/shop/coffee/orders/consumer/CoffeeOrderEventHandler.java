package com.ckai.shop.coffee.orders.consumer;

import com.ckai.shop.coffee.orders.CoffeeOrderRepository;
import com.ckai.shop.coffee.orders.entity.CoffeeOrder;
import com.ckai.shop.coffee.orders.events.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Component
public class CoffeeOrderEventHandler {

    @Autowired
    private CoffeeOrderRepository repository;

    public void handle(CoffeeOrderPlacedEvent event) {
        CoffeeOrder coffeeOrder = repository.findById(event.getOrderId()).orElse(new CoffeeOrder());
        coffeeOrder.place(event.getOrderId(), event.getBeanOrigin(), event.getCoffeeType());
        repository.save(coffeeOrder);
    }

    public void handle(CoffeeOrderAcceptedEvent event) {
        applyFor(event.getOrderId(), CoffeeOrder::accept);
    }

    public void handle(CoffeeOrderStartedEvent event) {
        applyFor(event.getOrderId(), CoffeeOrder::start);
    }

    public void handle(CoffeeOrderFinishedEvent event) {
        applyFor(event.getOrderId(), CoffeeOrder::finish);
    }

    public void handle(CoffeeOrderDeliveredEvent event) {
        applyFor(event.getOrderId(), CoffeeOrder::deliver);
    }

    public void handle(CoffeeOrderCancelledEvent event) {
        applyFor(event.getOrderId(), CoffeeOrder::cancel);
    }

    private void applyFor(final String orderId, final Consumer<CoffeeOrder> consumer) {
        Optional<CoffeeOrder> order = repository.findById(orderId);
        if (order.isPresent()) {
            consumer.accept(order.get());
            repository.save(order.get());
        }
    }
}
