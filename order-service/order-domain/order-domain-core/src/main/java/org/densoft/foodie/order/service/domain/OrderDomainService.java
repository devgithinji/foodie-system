package org.densoft.foodie.order.service.domain;

import org.densoft.foodie.domain.event.publisher.DomainEventPublisher;
import org.densoft.foodie.order.service.domain.entity.Order;
import org.densoft.foodie.order.service.domain.entity.Restaurant;
import org.densoft.foodie.order.service.domain.event.OrderCancelledEvent;
import org.densoft.foodie.order.service.domain.event.OrderCreatedEvent;
import org.densoft.foodie.order.service.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {
    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant, DomainEventPublisher<OrderCreatedEvent> orderCreatedEventDomainEventPublisher);

    OrderPaidEvent payOrder(Order order, DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages, DomainEventPublisher<OrderCancelledEvent> orderCancelledEventDomainEventPublisher);

    void cancelOrder(Order order, List<String> failureMessages);
}
