package org.densoft.foodie.order.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.densoft.foodie.order.service.domain.dto.create.CreateOrderCommand;
import org.densoft.foodie.order.service.domain.dto.create.CreateOrderResponse;
import org.densoft.foodie.order.service.domain.dto.track.TrackOrderQuery;
import org.densoft.foodie.order.service.domain.dto.track.TrackOrderResponse;
import org.densoft.foodie.order.service.domain.ports.input.service.OrderApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderCreateCommandHandler orderCreateCommandHandler;
    private final OrderTrackCommandHandler orderTrackCommandHandler;

    public OrderApplicationServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler, OrderTrackCommandHandler orderTrackCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
        this.orderTrackCommandHandler = orderTrackCommandHandler;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return orderTrackCommandHandler.trackOrder(trackOrderQuery);
    }
}
