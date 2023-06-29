package org.densoft.foodie.order.service.dataaccess.resturant.mapper;

import org.densoft.foodie.dataaccess.restaurant.entity.RestaurantEntity;
import org.densoft.foodie.dataaccess.restaurant.exception.RestaurantDataAccessException;
import org.densoft.foodie.domain.valueobject.Money;
import org.densoft.foodie.domain.valueobject.ProductId;
import org.densoft.foodie.domain.valueobject.RestaurantId;
import org.densoft.foodie.order.service.domain.entity.Product;
import org.densoft.foodie.order.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RestaurantDataAccessMapper {
    public List<UUID> restaurantToRestaurantProducts(Restaurant restaurant) {
        return restaurant.getProducts().stream().map(product -> product.getId().getValue())
                .toList();
    }

    public Restaurant restaurantEntityToRestaurant(List<RestaurantEntity> restaurantEntities) {
        RestaurantEntity restaurantEntity = restaurantEntities.stream().findFirst().orElseThrow(() ->
                new RestaurantDataAccessException("Restaurant could not be found"));

        List<Product> restaurantProducts = restaurantEntities.stream().map(entity ->
                        new Product(new ProductId(entity.getProductId()), entity.getProductName(), new Money(entity.getProductPrice())))
                .toList();

        return Restaurant.builder()
                .restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
                .products(restaurantProducts)
                .active(restaurantEntity.getRestaurantActive())
                .build();

    }
}
