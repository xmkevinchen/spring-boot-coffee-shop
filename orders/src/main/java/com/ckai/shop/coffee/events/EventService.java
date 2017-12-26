package com.ckai.shop.coffee.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */
@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    private void save(Event event) {
        Long version = repository
                .findTopVersionByAggregateIdAndAggregateOrderByVersionDesc(event.getAggregateId(), event.getAggregate())
                .orElse(0L);
        event.setVersion(version + 1L);
        repository.save(event);
    }

}
