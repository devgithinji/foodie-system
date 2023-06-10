package org.densoft.foodie.order.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.densoft.foodie.order.service.domain.dto.message.RestaurantApprovalResponse;
import org.densoft.foodie.order.service.domain.ports.input.message.listener.requestapproval.RestaurantApprovalResponseMessageListener;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
public class RestaurantApprovalResponseMessageListenerImpl implements RestaurantApprovalResponseMessageListener {
    @Override
    public void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse) {

    }

    @Override
    public void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse) {

    }
}
