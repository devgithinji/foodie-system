package org.densoft.foodie.restaurant.service.domain.ports.ouput.respository;

import org.densoft.foodie.retaurant.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
