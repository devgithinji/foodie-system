package org.densoft.foodie.order.service.domain.ports.output.message.publisher.payment;

import org.densoft.foodie.domain.event.publisher.DomainEventPublisher;
import org.densoft.foodie.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {

}
