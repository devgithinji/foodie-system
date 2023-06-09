package org.densoft.foodie.payment.service.messaging.publisher.kafka;

import lombok.extern.slf4j.Slf4j;
import org.densoft.foodie.kafka.order.avro.model.PaymentResponseAvroModel;
import org.densoft.foodie.kafka.producer.KafkaMessageHelper;
import org.densoft.foodie.kafka.producer.service.KafkaProducer;
import org.densoft.foodie.payment.service.domain.config.PaymentServiceConfigData;
import org.densoft.foodie.payment.service.domain.event.PaymentCancelledEvent;
import org.densoft.foodie.payment.service.domain.event.PaymentCompletedEvent;
import org.densoft.foodie.payment.service.domain.ports.output.message.publisher.PaymentCancelledMessagePublisher;
import org.densoft.foodie.payment.service.domain.ports.output.message.publisher.PaymentCompletedMessagePublisher;
import org.densoft.foodie.payment.service.messaging.mapper.PaymentMessagingDataMapper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentCancelledKafkaMessagePublisher implements PaymentCancelledMessagePublisher {

    private final PaymentMessagingDataMapper paymentMessagingDataMapper;
    private final KafkaProducer<String, PaymentResponseAvroModel> kafkaProducer;
    private final PaymentServiceConfigData paymentServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;

    public PaymentCancelledKafkaMessagePublisher(PaymentMessagingDataMapper paymentMessagingDataMapper,
                                                 KafkaProducer<String, PaymentResponseAvroModel> kafkaProducer,
                                                 PaymentServiceConfigData paymentServiceConfigData,
                                                 KafkaMessageHelper kafkaMessageHelper) {
        this.paymentMessagingDataMapper = paymentMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.paymentServiceConfigData = paymentServiceConfigData;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(PaymentCancelledEvent domainEvent) {
        String orderId = domainEvent.getPayment().getOrderId().getValue().toString();

        log.info("Received PaymentCancelledEvent for order id: {}", orderId);

        try {
            PaymentResponseAvroModel paymentResponseAvroModel = paymentMessagingDataMapper.paymentCancelledEventToPaymentResponseAvroModel(domainEvent);

            kafkaProducer.send(paymentServiceConfigData.getPaymentResponseTopicName(),
                    orderId,
                    paymentResponseAvroModel,
                    kafkaMessageHelper.getKafkaCallback(paymentServiceConfigData.getPaymentRequestTopicName(),
                            paymentResponseAvroModel,
                            orderId,
                            "PaymentResponseAvroModel"));

            log.info("PaymentResponseAvroModel sent to kafka for order id: {}", orderId);

        } catch (Exception e) {
           log.error("Error while sending PaymentResponseAvroModel message to kafka with order id: {}, error: {}", orderId, e.getMessage());
        }
    }
}
