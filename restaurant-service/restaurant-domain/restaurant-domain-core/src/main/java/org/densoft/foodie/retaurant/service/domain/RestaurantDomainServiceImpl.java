package org.densoft.foodie.retaurant.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.densoft.foodie.domain.event.publisher.DomainEventPublisher;
import org.densoft.foodie.domain.value.OrderApprovalStatus;
import org.densoft.foodie.retaurant.service.domain.entity.Restaurant;
import org.densoft.foodie.retaurant.service.domain.event.OrderApprovalEvent;
import org.densoft.foodie.retaurant.service.domain.event.OrderApprovedEvent;
import org.densoft.foodie.retaurant.service.domain.event.OrderRejectedEvent;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.densoft.foodie.domain.DomainConstants.UTC;

@Slf4j
public class RestaurantDomainServiceImpl implements RestaurantDomainService {
    @Override
    public OrderApprovalEvent validateOrder(Restaurant restaurant,
                                            List<String> failureMessages,
                                            DomainEventPublisher<OrderApprovedEvent> orderApprovedEventDomainEventPublisher,
                                            DomainEventPublisher<OrderRejectedEvent> orderRejectedEventDomainEventPublisher) {
        restaurant.validateOrder(failureMessages);
        log.info("Validating order with id: {}", restaurant.getOrderDetail().getId().getValue());

        if (failureMessages.isEmpty()) {

            log.info("Order is approved for order id: {}", restaurant.getOrderDetail().getId().getValue());
            restaurant.constructOrderApproval(OrderApprovalStatus.APPROVED);
            return new OrderApprovedEvent(restaurant.getOrderApproval(),
                    restaurant.getId(),
                    failureMessages,
                    ZonedDateTime.now(ZoneId.of(UTC)),
                    orderApprovedEventDomainEventPublisher);

        } else {

            log.info("Order is rejected for order id: {}", restaurant.getOrderDetail().getId().getValue());
            restaurant.constructOrderApproval(OrderApprovalStatus.REJECTED);
            return new OrderRejectedEvent(restaurant.getOrderApproval(),
                    restaurant.getId(),
                    failureMessages,
                    ZonedDateTime.now(ZoneId.of(UTC)),
                    orderRejectedEventDomainEventPublisher);

        }

    }
}
