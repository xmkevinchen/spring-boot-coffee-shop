package com.ckai.shop.coffee.orders;

import com.ckai.shop.coffee.orders.entity.CoffeeOrder;
import com.ckai.shop.coffee.orders.events.order.*;
import com.ckai.shop.coffee.orders.producer.CoffeeOrderEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Service
public class OrderCommandService {

    @Autowired
    private CoffeeOrderEventProducer producer;

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    String placeOrder(final CoffeeOrder order) {
        String orderId = UUID.randomUUID().toString();
        producer.publish(new CoffeeOrderPlacedEvent(orderId, order.getBeanOrigin(), order.getCoffeeType()));
        return orderId;
    }

    void acceptOrder(final String orderId) {
        coffeeOrderRepository.findById(orderId)
                .ifPresent(coffeeOrder -> {
                    producer.publish(new CoffeeOrderAcceptedEvent(orderId,
                            coffeeOrder.getBeanOrigin(),
                            coffeeOrder.getCoffeeType()));
                });
    }

    void startOrder(final String orderId) {
        producer.publish(new CoffeeOrderStartedEvent(orderId));
    }

    void finishOrder(final String orderId) {
        producer.publish(new CoffeeOrderFinishedEvent(orderId));
    }

    void deliverOrder(final String orderId) {
        producer.publish(new CoffeeOrderDeliveredEvent(orderId));
    }

}
