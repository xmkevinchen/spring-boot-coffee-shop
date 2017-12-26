package com.ckai.shop.coffee.events;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Repository
public interface EventRepository extends CrudRepository<Event, String> {

    List<Event> findByAggregateIdAndAggregateOrderByVersionAsc(String aggregateId, String aggregate);

    Optional<Long> findTopVersionByAggregateIdAndAggregateOrderByVersionDesc(String aggregateId, String aggregate);
}
