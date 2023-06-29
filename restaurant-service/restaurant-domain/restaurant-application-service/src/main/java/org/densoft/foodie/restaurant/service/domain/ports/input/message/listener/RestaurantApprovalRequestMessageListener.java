package org.densoft.foodie.restaurant.service.domain.ports.input.message.listener;

import org.densoft.foodie.restaurant.service.domain.dto.RestaurantApprovalRequest;

public interface RestaurantApprovalRequestMessageListener {

    void approveOrder(RestaurantApprovalRequest restaurantApprovalRequest);
}
