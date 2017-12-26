package com.ckai.shop.coffee.orders.producer;

import com.ckai.shop.coffee.orders.events.CoffeeEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Component
public class CoffeeOrderEventProducer {

    @Value(value = "${kafka.orders.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, CoffeeEventMessage> coffeeOrderSender;

    @Autowired
    private ObjectMapper objectMapper;

    public void publish(CoffeeEvent event) {

        try {
            String eventType = event.getClass().getSimpleName();
            String message = objectMapper.writeValueAsString(event);
            coffeeOrderSender.send(topic, new CoffeeEventMessage(eventType, message));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

}
