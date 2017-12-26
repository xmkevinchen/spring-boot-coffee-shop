package com.ckai.shop.coffee.events;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

/**
 * @author Kevin Chen
 * CreatedAt: 12/25/17
 */

@Document(collection = "events")
@Data
public class Event {

    @Id
    private UUID eventId;

    private String aggregateId;
    private String aggregate;
    private Long version;
    private Date timestamp;
    private String eventType;
    private Object payload;
    private Object metadata;

}
