package org.densoft.foodie.domain.event;

public interface DomainEvent<T> {
    void fire();
}
