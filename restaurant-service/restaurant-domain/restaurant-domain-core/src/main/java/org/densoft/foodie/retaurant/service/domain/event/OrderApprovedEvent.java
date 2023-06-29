package org.densoft.foodie.retaurant.service.domain.event;

import org.densoft.foodie.domain.event.publisher.DomainEventPublisher;
import org.densoft.foodie.domain.valueobject.RestaurantId;
import org.densoft.foodie.retaurant.service.domain.entity.OrderApproval;

import java.time.ZonedDateTime;
import java.util.List;

public class OrderApprovedEvent extends OrderApprovalEvent {

    private final DomainEventPublisher<OrderApprovedEvent> orderApprovalEventDomainEventPublisher;

    public OrderApprovedEvent(OrderApproval orderApproval,
                              RestaurantId restaurantId,
                              List<String> failureMessages,
                              ZonedDateTime createdAt, DomainEventPublisher<OrderApprovedEvent> orderApprovalEventDomainEventPublisher) {
        super(orderApproval, restaurantId, failureMessages, createdAt);
        this.orderApprovalEventDomainEventPublisher = orderApprovalEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        orderApprovalEventDomainEventPublisher.publish(this);
    }
}
