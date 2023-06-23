package org.densoft.foodie.order.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "org.densoft.foodie.order.service.dataaccess")
@EntityScan(basePackages = "org.densoft.foodie.order.service.dataaccess")
@SpringBootApplication(scanBasePackages = "org.densoft.foodie")
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
