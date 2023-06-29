package org.densoft.foodie.restaurant.service.domain.mapper;


import org.densoft.foodie.domain.valueobject.Money;
import org.densoft.foodie.domain.valueobject.OrderId;
import org.densoft.foodie.domain.valueobject.OrderStatus;
import org.densoft.foodie.domain.valueobject.RestaurantId;
import org.densoft.foodie.restaurant.service.domain.dto.RestaurantApprovalRequest;
import org.densoft.foodie.retaurant.service.domain.entity.OrderDetail;
import org.densoft.foodie.retaurant.service.domain.entity.Product;
import org.densoft.foodie.retaurant.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RestaurantDataMapper {

    public Restaurant restaurantApprovalRequestToRestaurant(RestaurantApprovalRequest restaurantApprovalRequest) {
        return Restaurant.builder()
                .restaurantId(new RestaurantId(UUID.fromString(restaurantApprovalRequest.getRestaurantId())))
                .orderDetail(OrderDetail.builder()
                        .orderId(new OrderId(UUID.fromString(restaurantApprovalRequest.getOrderId())))
                        .products(restaurantApprovalRequest.getProducts().stream().map(product -> Product.builder()
                                .productId(product.getId())
                                .quantity(product.getQuantity())
                                .build()).toList())
                        .totalAmount(new Money(restaurantApprovalRequest.getPrice()))
                        .orderStatus(OrderStatus.valueOf(restaurantApprovalRequest.getRestaurantOrderStatus().name()))
                        .build())
                .build();

    }
}
