package org.densoft.foodie.restaurant.service.dataaccess.restaurant.adapter;

import org.densoft.foodie.dataaccess.restaurant.entity.RestaurantEntity;
import org.densoft.foodie.dataaccess.restaurant.respository.RestaurantJpaRepository;
import org.densoft.foodie.restaurant.service.dataaccess.restaurant.mapper.RestaurantDataAccessMapper;
import org.densoft.foodie.restaurant.service.domain.ports.ouput.respository.RestaurantRepository;
import org.densoft.foodie.retaurant.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private final RestaurantJpaRepository restaurantJpaRepository;
    private final RestaurantDataAccessMapper restaurantDataAccessMapper;


    public RestaurantRepositoryImpl(RestaurantJpaRepository restaurantJpaRepository, RestaurantDataAccessMapper restaurantDataAccessMapper) {
        this.restaurantJpaRepository = restaurantJpaRepository;
        this.restaurantDataAccessMapper = restaurantDataAccessMapper;
    }

    @Override
    public Optional<Restaurant> findRestaurantInformation(Restaurant restaurant) {
        List<UUID> restaurantProducts = restaurantDataAccessMapper.restaurantToRestaurantProducts(restaurant);
        Optional<List<RestaurantEntity>> restaurantEntities = restaurantJpaRepository.findByRestaurantIdAndProductIdIn(restaurant.getId().getValue(),
                restaurantProducts);
        return restaurantEntities.map(restaurantDataAccessMapper::restaurantEntityToRestaurant);
    }
}
