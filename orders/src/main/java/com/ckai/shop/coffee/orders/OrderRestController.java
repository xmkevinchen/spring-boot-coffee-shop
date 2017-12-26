package com.ckai.shop.coffee.orders;

import com.ckai.shop.coffee.orders.entity.CoffeeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@RestController
@RequestMapping(value = "/api/orders")
public class OrderRestController {

    @Autowired
    private OrderCommandService commandService;
    @Autowired
    private OrderQueryService queryService;

    @PostMapping
    ResponseEntity<Void> placeOrder(@RequestBody CoffeeOrder order, UriComponentsBuilder uriBuilder) {

        if (order.getBeanOrigin() == null || order.getCoffeeType() == null) {
            return ResponseEntity.badRequest().build();
        }

        final String orderId = commandService.placeOrder(order);
        return ResponseEntity
                .created(uriBuilder.path("/{orderId}")
                        .buildAndExpand(orderId).toUri())
                .build();
    }

    @GetMapping("/{orderId}")
    ResponseEntity getOrder(@PathVariable String orderId) {

        return queryService.getOrder(orderId)
                .<ResponseEntity>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
