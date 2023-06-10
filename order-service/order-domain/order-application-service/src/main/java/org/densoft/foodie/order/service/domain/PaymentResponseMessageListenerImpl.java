package org.densoft.foodie.order.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.densoft.foodie.order.service.domain.dto.message.PaymentResponse;
import org.densoft.foodie.order.service.domain.ports.input.message.listener.payment.PaymentResponseMessageListener;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Slf4j
@Validated
public class PaymentResponseMessageListenerImpl implements PaymentResponseMessageListener {
    @Override
    public void paymentCompleted(PaymentResponse paymentResponse) {

    }

    @Override
    public void paymentCancelled(PaymentResponse paymentResponse) {

    }
}
