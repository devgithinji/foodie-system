package org.densoft.foodie.payment.service.domain.ports.input.message.listener;

import org.densoft.foodie.payment.service.domain.dto.PaymentRequest;

public interface PaymentRequestMessageListener {
    void completePayment(PaymentRequest paymentRequest);

    void cancelPayment(PaymentRequest paymentRequest);
}
