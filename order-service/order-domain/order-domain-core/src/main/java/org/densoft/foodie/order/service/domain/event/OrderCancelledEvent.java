package org.densoft.foodie.order.service.domain.event;

import org.densoft.foodie.domain.event.DomainEvent;
import org.densoft.foodie.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent {

    public OrderCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
