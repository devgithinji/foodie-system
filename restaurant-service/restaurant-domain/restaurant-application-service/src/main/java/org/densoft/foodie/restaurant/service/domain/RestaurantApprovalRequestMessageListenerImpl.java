package org.densoft.foodie.restaurant.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.densoft.foodie.restaurant.service.domain.dto.RestaurantApprovalRequest;
import org.densoft.foodie.restaurant.service.domain.ports.input.message.listener.RestaurantApprovalRequestMessageListener;
import org.densoft.foodie.retaurant.service.domain.event.OrderApprovalEvent;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RestaurantApprovalRequestMessageListenerImpl implements RestaurantApprovalRequestMessageListener {

    private final RestaurantApprovalRequestHelper restaurantApprovalRequestHelper;

    public RestaurantApprovalRequestMessageListenerImpl(RestaurantApprovalRequestHelper restaurantApprovalRequestHelper) {
        this.restaurantApprovalRequestHelper = restaurantApprovalRequestHelper;
    }

    @Override
    public void approveOrder(RestaurantApprovalRequest restaurantApprovalRequest) {
        OrderApprovalEvent orderApprovalEvent = restaurantApprovalRequestHelper.persistOrderApproval(restaurantApprovalRequest);
        orderApprovalEvent.fire();
    }
}
