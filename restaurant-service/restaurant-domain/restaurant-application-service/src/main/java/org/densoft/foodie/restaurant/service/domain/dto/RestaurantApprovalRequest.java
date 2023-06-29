package org.densoft.foodie.restaurant.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.densoft.foodie.domain.valueobject.RestaurantOrderStatus;
import org.densoft.foodie.retaurant.service.domain.entity.Product;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RestaurantApprovalRequest {
    private String id;
    private String  sagaId;
    private String restaurantId;
    private String orderId;
    private RestaurantOrderStatus restaurantOrderStatus;
    private List<Product> products;
    private BigDecimal price;
    private Instant createAt;
}
