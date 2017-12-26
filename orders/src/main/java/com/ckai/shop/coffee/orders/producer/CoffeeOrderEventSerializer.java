package com.ckai.shop.coffee.orders.producer;

import com.ckai.shop.coffee.orders.events.CoffeeEvent;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
public class CoffeeOrderEventSerializer implements Serializer<CoffeeEvent> {



    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, CoffeeEvent event) {
        return new byte[0];
    }

    @Override
    public void close() {

    }
}
