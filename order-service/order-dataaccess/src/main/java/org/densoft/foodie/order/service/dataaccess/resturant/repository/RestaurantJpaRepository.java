package org.densoft.foodie.order.service.dataaccess.resturant.repository;

import org.densoft.foodie.order.service.dataaccess.resturant.entity.RestaurantEntity;
import org.densoft.foodie.order.service.dataaccess.resturant.entity.RestaurantEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity, RestaurantEntityId> {
    Optional<List<RestaurantEntity>> findByRestaurantIdAndProductIdIn(UUID restaurantId, List<UUID> productIds);
}
