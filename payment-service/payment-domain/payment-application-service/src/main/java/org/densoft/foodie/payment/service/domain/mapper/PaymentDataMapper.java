package org.densoft.foodie.payment.service.domain.mapper;

import org.densoft.foodie.domain.value.CustomerId;
import org.densoft.foodie.domain.value.Money;
import org.densoft.foodie.domain.value.OrderId;
import org.densoft.foodie.payment.service.domain.dto.PaymentRequest;
import org.densoft.foodie.payment.service.domain.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PaymentDataMapper {

    public Payment paymentRequestModelToPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .orderId(new OrderId(UUID.fromString(paymentRequest.getOrderId())))
                .customerId(new CustomerId(UUID.fromString(paymentRequest.getCustomerId())))
                .price(new Money(paymentRequest.getPrice()))
                .build();
    }
}
