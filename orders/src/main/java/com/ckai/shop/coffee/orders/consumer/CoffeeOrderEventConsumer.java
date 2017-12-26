package com.ckai.shop.coffee.orders.consumer;

import com.ckai.shop.coffee.orders.events.order.CoffeeOrderEvent;
import com.ckai.shop.coffee.orders.producer.CoffeeEventMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Component
public class CoffeeOrderEventConsumer {

    @Autowired
    private CoffeeOrderEventHandler eventHandler;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.orders.topic}",
            containerFactory = "orderKafkaListenerContainerFactory")
    public void receive(CoffeeEventMessage message) {

        try {
            String eventType = message.getEventType();
            String packageName = CoffeeOrderEvent.class.getPackage().getName();
            Class<? extends CoffeeOrderEvent> eventClass = (Class<? extends CoffeeOrderEvent>) Class.forName(packageName + "." + eventType);
            Object event = objectMapper.readValue(message.getMessage(), eventClass);
            Method method = eventHandler.getClass().getMethod("handle", eventClass);
            method.invoke(eventHandler, event);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
