package org.densoft.foodie.restaurant.service.dataaccess.restaurant.mapper;

import org.densoft.foodie.dataaccess.restaurant.entity.RestaurantEntity;
import org.densoft.foodie.dataaccess.restaurant.exception.RestaurantDataAccessException;
import org.densoft.foodie.domain.valueobject.Money;
import org.densoft.foodie.domain.valueobject.OrderId;
import org.densoft.foodie.domain.valueobject.ProductId;
import org.densoft.foodie.domain.valueobject.RestaurantId;
import org.densoft.foodie.restaurant.service.dataaccess.restaurant.entity.OrderApprovalEntity;
import org.densoft.foodie.retaurant.service.domain.entity.OrderApproval;
import org.densoft.foodie.retaurant.service.domain.entity.OrderDetail;
import org.densoft.foodie.retaurant.service.domain.entity.Product;
import org.densoft.foodie.retaurant.service.domain.entity.Restaurant;
import org.densoft.foodie.retaurant.service.domain.valueobject.OrderApprovalId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RestaurantDataAccessMapper {
    public List<UUID> restaurantToRestaurantProducts(Restaurant restaurant) {
        return restaurant.getOrderDetail().getProducts().stream()
                .map(product -> product.getId().getValue())
                .toList();
    }

    public Restaurant restaurantEntityToRestaurant(List<RestaurantEntity> restaurantEntities) {
        RestaurantEntity restaurantEntity = restaurantEntities.stream().findFirst().orElseThrow(() ->
                new RestaurantDataAccessException("No repositories found!"));

        List<Product> restaurantProducts = restaurantEntities.stream().map(entity -> Product.builder()
                        .productId(new ProductId(entity.getProductId()))
                        .name(entity.getProductName())
                        .price(new Money(entity.getProductPrice()))
                        .available(entity.getProductAvailable())
                        .build())
                .toList();

        return Restaurant.builder()
                .restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
                .orderDetail(OrderDetail.builder()
                        .products(restaurantProducts)
                        .build())
                .active(restaurantEntity.getRestaurantActive())
                .build();
    }

    public OrderApprovalEntity orderApprovalToOrderApprovalEntity(OrderApproval orderApproval) {
        return OrderApprovalEntity.builder()
                .id(orderApproval.getId().getValue())
                .restaurantId(orderApproval.getRestaurantId().getValue())
                .orderId(orderApproval.getOrderId().getValue())
                .status(orderApproval.getApprovalStatus())
                .build();
    }

    public OrderApproval orderApprovalEntityToOrderApproval(OrderApprovalEntity orderApprovalEntity) {
        return OrderApproval.builder()
                .orderApprovalId(new OrderApprovalId(orderApprovalEntity.getId()))
                .restaurantId(new RestaurantId(orderApprovalEntity.getRestaurantId()))
                .orderId(new OrderId(orderApprovalEntity.getOrderId()))
                .approvalStatus(orderApprovalEntity.getStatus())
                .build();
    }
}
