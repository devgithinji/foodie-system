package org.densoft.foodie.order.service.domain.ports.output.message.publisher.resturantapproval;

import org.densoft.foodie.domain.event.publisher.DomainEventPublisher;
import org.densoft.foodie.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
