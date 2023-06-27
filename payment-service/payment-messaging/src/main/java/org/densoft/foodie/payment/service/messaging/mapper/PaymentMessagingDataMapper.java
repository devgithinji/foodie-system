package org.densoft.foodie.payment.service.messaging.mapper;

import org.densoft.foodie.kafka.order.avro.model.PaymentRequestAvroModel;
import org.densoft.foodie.kafka.order.avro.model.PaymentResponseAvroModel;
import org.densoft.foodie.kafka.order.avro.model.PaymentStatus;
import org.densoft.foodie.payment.service.domain.dto.PaymentRequest;
import org.densoft.foodie.payment.service.domain.entity.Payment;
import org.densoft.foodie.payment.service.domain.event.PaymentCancelledEvent;
import org.densoft.foodie.payment.service.domain.event.PaymentCompletedEvent;
import org.densoft.foodie.payment.service.domain.event.PaymentFailedEvent;
import org.densoft.foodie.payment.service.domain.valueobject.PaymentOrderStatus;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class PaymentMessagingDataMapper {
    public PaymentResponseAvroModel paymentCompletedEventToPaymentResponseAvroModel(PaymentCompletedEvent paymentCompletedEvent) {
        return getPaymentResponseAvroModel(paymentCompletedEvent.getPayment(), paymentCompletedEvent.getCreatedAt(), paymentCompletedEvent.getFailureMessages());
    }

    public PaymentResponseAvroModel paymentCancelledEventToPaymentResponseAvroModel(PaymentCancelledEvent paymentCancelledEvent) {

        return getPaymentResponseAvroModel(paymentCancelledEvent.getPayment(), paymentCancelledEvent.getCreatedAt(), paymentCancelledEvent.getFailureMessages());
    }

    public PaymentResponseAvroModel paymentFailedEventToPaymentResponseAvroModel(PaymentFailedEvent paymentFailedEvent) {
        return getPaymentResponseAvroModel(paymentFailedEvent.getPayment(), paymentFailedEvent.getCreatedAt(), paymentFailedEvent.getFailureMessages());
    }

    private PaymentResponseAvroModel getPaymentResponseAvroModel(Payment payment, ZonedDateTime createdAt, List<String> failureMessages) {
        return PaymentResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setPaymentId(payment.getId().getValue().toString())
                .setCustomerId(payment.getCustomerId().getValue().toString())
                .setOrderId(payment.getOrderId().getValue().toString())
                .setPrice(payment.getPrice().getAmount())
                .setCreatedAt(createdAt.toInstant())
                .setPaymentStatus(PaymentStatus.valueOf(payment.getPaymentStatus().name()))
                .setFailureMessages(failureMessages)
                .build();
    }


    public PaymentRequest paymentRequestAvroModelToPaymentRequest(PaymentRequestAvroModel paymentRequestAvroModel) {
        return PaymentRequest.builder()
                .id(paymentRequestAvroModel.getId())
                .sagaId(paymentRequestAvroModel.getSagaId())
                .customerId(paymentRequestAvroModel.getCustomerId())
                .orderId(paymentRequestAvroModel.getOrderId())
                .price(paymentRequestAvroModel.getPrice())
                .createdAt(paymentRequestAvroModel.getCreatedAt())
                .paymentOrderStatus(PaymentOrderStatus.valueOf(paymentRequestAvroModel.getPaymentOrderStatus().name()))
                .build();
    }

}
