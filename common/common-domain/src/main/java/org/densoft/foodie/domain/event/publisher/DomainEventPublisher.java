package org.densoft.foodie.domain.event.publisher;

import org.densoft.foodie.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T domainEvent);
}
