package org.densoft.foodie.order.service.domain.ports.output.message.publisher.payment;

import org.densoft.foodie.domain.event.publisher.DomainEventPublisher;
import org.densoft.foodie.order.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
