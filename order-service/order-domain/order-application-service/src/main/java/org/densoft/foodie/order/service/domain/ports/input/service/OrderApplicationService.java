package org.densoft.foodie.order.service.domain.ports.input.service;

import org.densoft.foodie.order.service.domain.dto.create.CreateOrderCommand;
import org.densoft.foodie.order.service.domain.dto.create.CreateOrderResponse;
import org.densoft.foodie.order.service.domain.dto.track.TrackOrderResponse;

import javax.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderResponse trackOrderResponse);
}
