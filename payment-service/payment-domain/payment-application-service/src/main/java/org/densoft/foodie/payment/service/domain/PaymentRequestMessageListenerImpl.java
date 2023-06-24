package org.densoft.foodie.payment.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.densoft.foodie.payment.service.domain.dto.PaymentRequest;
import org.densoft.foodie.payment.service.domain.ports.input.message.listener.PaymentRequestMessageListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentRequestMessageListenerImpl implements PaymentRequestMessageListener {
    @Override
    public void completePayment(PaymentRequest paymentRequest) {

    }

    @Override
    public void cancelPayment(PaymentRequest paymentRequest) {

    }
}
