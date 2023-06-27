package org.densoft.foodie.payment.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "org.densoft.foodie.payment.service.dataaccess")
@EntityScan(basePackages = "org.densoft.foodie.payment.service.dataaccess")
@SpringBootApplication(scanBasePackages = "org.densoft.foodie")
public class PaymentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
