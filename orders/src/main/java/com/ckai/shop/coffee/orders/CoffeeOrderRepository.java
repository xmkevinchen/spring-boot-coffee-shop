package com.ckai.shop.coffee.orders;

import com.ckai.shop.coffee.orders.entity.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Repository
public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, String> {

}
