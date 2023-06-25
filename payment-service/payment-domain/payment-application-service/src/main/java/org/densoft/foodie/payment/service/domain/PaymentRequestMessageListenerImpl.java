package org.densoft.foodie.payment.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.densoft.foodie.payment.service.domain.dto.PaymentRequest;
import org.densoft.foodie.payment.service.domain.event.PaymentCancelledEvent;
import org.densoft.foodie.payment.service.domain.event.PaymentCompletedEvent;
import org.densoft.foodie.payment.service.domain.event.PaymentEvent;
import org.densoft.foodie.payment.service.domain.event.PaymentFailedEvent;
import org.densoft.foodie.payment.service.domain.ports.input.message.listener.PaymentRequestMessageListener;
import org.densoft.foodie.payment.service.domain.ports.output.message.publisher.PaymentCancelledMessagePublisher;
import org.densoft.foodie.payment.service.domain.ports.output.message.publisher.PaymentCompletedMessagePublisher;
import org.densoft.foodie.payment.service.domain.ports.output.message.publisher.PaymentFailedMessagePublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentRequestMessageListenerImpl implements PaymentRequestMessageListener {


    private final PaymentRequestHelper paymentRequestHelper;
    private final PaymentCompletedMessagePublisher paymentCompletedMessagePublisher;
    private final PaymentCancelledMessagePublisher paymentCancelledMessagePublisher;
    private final PaymentFailedMessagePublisher paymentFailedMessagePublisher;


    public PaymentRequestMessageListenerImpl(PaymentRequestHelper paymentRequestHelper,
                                             PaymentCompletedMessagePublisher paymentCompletedMessagePublisher,
                                             PaymentCancelledMessagePublisher paymentCancelledMessagePublisher,
                                             PaymentFailedMessagePublisher paymentFailedMessagePublisher) {
        this.paymentRequestHelper = paymentRequestHelper;
        this.paymentCompletedMessagePublisher = paymentCompletedMessagePublisher;
        this.paymentCancelledMessagePublisher = paymentCancelledMessagePublisher;
        this.paymentFailedMessagePublisher = paymentFailedMessagePublisher;
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
        if (paymentEvent instanceof PaymentCompletedEvent) {
            paymentCompletedMessagePublisher.publish((PaymentCompletedEvent) paymentEvent);
        } else if (paymentEvent instanceof PaymentCancelledEvent) {
            paymentCancelledMessagePublisher.publish((PaymentCancelledEvent) paymentEvent);
        }else if(paymentEvent instanceof PaymentFailedEvent){
            paymentFailedMessagePublisher.publish((PaymentFailedEvent) paymentEvent);
        }

    }
}
