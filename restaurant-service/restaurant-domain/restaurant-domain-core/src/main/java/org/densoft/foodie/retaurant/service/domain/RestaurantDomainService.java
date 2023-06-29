package org.densoft.foodie.retaurant.service.domain;

import org.densoft.foodie.domain.event.publisher.DomainEventPublisher;
import org.densoft.foodie.retaurant.service.domain.entity.Restaurant;
import org.densoft.foodie.retaurant.service.domain.event.OrderApprovalEvent;
import org.densoft.foodie.retaurant.service.domain.event.OrderApprovedEvent;
import org.densoft.foodie.retaurant.service.domain.event.OrderRejectedEvent;

import java.util.List;

public interface RestaurantDomainService {
    OrderApprovalEvent validateOrder(Restaurant restaurant,
                                     List<String> failureMessages,
                                     DomainEventPublisher<OrderApprovedEvent> orderApprovedEventDomainEventPublisher,
                                     DomainEventPublisher<OrderRejectedEvent> orderRejectedEventDomainEventPublisher);
}
