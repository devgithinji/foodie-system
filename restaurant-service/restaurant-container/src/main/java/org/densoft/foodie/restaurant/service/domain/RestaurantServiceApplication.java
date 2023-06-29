package org.densoft.foodie.restaurant.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"org.densoft.foodie.restaurant.service.dataaccess", "org.densoft.foodie.dataaccess"})
@EntityScan(basePackages = {"org.densoft.foodie.restaurant.service.dataaccess", "org.densoft.foodie.dataaccess"})
@SpringBootApplication(scanBasePackages = "org.densoft.foodie")
public class RestaurantServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }
}
