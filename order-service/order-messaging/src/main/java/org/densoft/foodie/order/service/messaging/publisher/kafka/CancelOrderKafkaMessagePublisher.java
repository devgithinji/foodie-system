package org.densoft.foodie.order.service.messaging.publisher.kafka;

import lombok.extern.slf4j.Slf4j;
import org.densoft.foodie.kafka.order.avro.model.PaymentRequestAvroModel;
import org.densoft.foodie.kafka.producer.KafkaMessageHelper;
import org.densoft.foodie.kafka.producer.service.KafkaProducer;
import org.densoft.foodie.order.service.domain.config.OrderServiceConfigData;
import org.densoft.foodie.order.service.domain.event.OrderCancelledEvent;
import org.densoft.foodie.order.service.domain.ports.output.message.publisher.payment.OrderCancelledPaymentRequestMessagePublisher;
import org.densoft.foodie.order.service.messaging.mapper.OrderMessagingDataMapper;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CancelOrderKafkaMessagePublisher implements OrderCancelledPaymentRequestMessagePublisher {

    private final OrderMessagingDataMapper orderMessagingDataMapper;
    private final OrderServiceConfigData orderServiceConfigData;
    private final KafkaProducer<String, PaymentRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper kafkaMessageHelper;

    public CancelOrderKafkaMessagePublisher(OrderMessagingDataMapper orderMessagingDataMapper,
                                            OrderServiceConfigData orderServiceConfigData,
                                            KafkaProducer<String, PaymentRequestAvroModel> kafkaProducer, KafkaMessageHelper kafkaMessageHelper) {
        this.orderMessagingDataMapper = orderMessagingDataMapper;
        this.orderServiceConfigData = orderServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(OrderCancelledEvent domainEvent) {
        String orderId = domainEvent.getOrder().getId().getValue().toString();

        log.info("Received OrderCancelledEvent for order id: {}", orderId);

        try {
            PaymentRequestAvroModel paymentRequestAvroModel = orderMessagingDataMapper.orderCancelledEventToPaymentRequestAvroModel(domainEvent);
            kafkaProducer.send(orderServiceConfigData.getPaymentRequestTopicName(),
                    orderId,
                    paymentRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(orderServiceConfigData.getPaymentResponseTopicName(),
                            paymentRequestAvroModel,
                            orderId,
                            "PaymentRequestAvroModel"));

            log.info("PaymentRequestAvroModel sent to Kafka for order id: {}", paymentRequestAvroModel.getOrderId());

        } catch (Exception e) {
            log.error("Error while sending PaymentRequestAvroModel message to kafka with order id: {}, error: {}", orderId, e.getMessage());
        }

    }
}
