package org.densoft.foodie.restaurant.service.domain.ports.ouput.message.publisher;

import org.densoft.foodie.domain.event.publisher.DomainEventPublisher;
import org.densoft.foodie.retaurant.service.domain.event.OrderRejectedEvent;

public interface OrderRejectedMessagePublisher extends DomainEventPublisher<OrderRejectedEvent> {
}
