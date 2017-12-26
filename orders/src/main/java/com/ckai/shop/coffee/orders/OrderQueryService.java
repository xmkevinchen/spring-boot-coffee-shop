package com.ckai.shop.coffee.orders;

import com.ckai.shop.coffee.orders.entity.CoffeeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Service
public class OrderQueryService {

    @Autowired
    private CoffeeOrderRepository repository;

    Optional<CoffeeOrder> getOrder(String orderId) {
        return repository.findById(orderId);
    }

}
