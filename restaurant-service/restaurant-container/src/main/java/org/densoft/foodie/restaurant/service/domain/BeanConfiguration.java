package org.densoft.foodie.restaurant.service.domain;

import org.densoft.foodie.retaurant.service.domain.RestaurantDomainService;
import org.densoft.foodie.retaurant.service.domain.RestaurantDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public RestaurantDomainService restaurantDomainService(){
        return new RestaurantDomainServiceImpl();
    }
}
