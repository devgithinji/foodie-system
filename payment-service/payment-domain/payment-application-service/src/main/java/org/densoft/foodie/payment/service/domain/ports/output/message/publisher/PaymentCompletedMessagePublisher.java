package org.densoft.foodie.payment.service.domain.ports.output.message.publisher;

import org.densoft.foodie.domain.event.publisher.DomainEventPublisher;
import org.densoft.foodie.payment.service.domain.event.PaymentCompletedEvent;

public interface PaymentCompletedMessagePublisher extends DomainEventPublisher<PaymentCompletedEvent> {

}
