package org.densoft.foodie.payment.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.densoft.foodie.payment.service.domain.dto.PaymentRequest;
import org.densoft.foodie.payment.service.domain.event.PaymentEvent;
import org.densoft.foodie.payment.service.domain.ports.input.message.listener.PaymentRequestMessageListener;
import org.densoft.foodie.payment.service.domain.ports.output.message.publisher.PaymentCancelledMessagePublisher;
import org.densoft.foodie.payment.service.domain.ports.output.message.publisher.PaymentCompletedMessagePublisher;
import org.densoft.foodie.payment.service.domain.ports.output.message.publisher.PaymentFailedMessagePublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentRequestMessageListenerImpl implements PaymentRequestMessageListener {


    private final PaymentRequestHelper paymentRequestHelper;


    public PaymentRequestMessageListenerImpl(PaymentRequestHelper paymentRequestHelper,
                                             PaymentCompletedMessagePublisher paymentCompletedMessagePublisher,
                                             PaymentCancelledMessagePublisher paymentCancelledMessagePublisher,
                                             PaymentFailedMessagePublisher paymentFailedMessagePublisher) {
        this.paymentRequestHelper = paymentRequestHelper;
    }

    @Override
    public void completePayment(PaymentRequest paymentRequest) {
        PaymentEvent paymentEvent = paymentRequestHelper.persistPayment(paymentRequest);
        fireEvent(paymentEvent);
    }

    @Override
    public void cancelPayment(PaymentRequest paymentRequest) {
        PaymentEvent paymentEvent = paymentRequestHelper.persistCancelPayment(paymentRequest);
        fireEvent(paymentEvent);
    }

    private void fireEvent(PaymentEvent paymentEvent) {
        log.info("Publishing payment event with payment id: {} and order id: {}",
                paymentEvent.getPayment().getId().getValue(),
                paymentEvent.getPayment().getOrderId().getValue());
        paymentEvent.fire();

    }
}
