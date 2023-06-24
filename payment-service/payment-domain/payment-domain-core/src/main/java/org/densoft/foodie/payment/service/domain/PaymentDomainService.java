package org.densoft.foodie.payment.service.domain;

import org.densoft.foodie.payment.service.domain.entity.CreditEntry;
import org.densoft.foodie.payment.service.domain.entity.CreditHistory;
import org.densoft.foodie.payment.service.domain.entity.Payment;
import org.densoft.foodie.payment.service.domain.event.PaymentEvent;

import java.util.List;

public interface PaymentDomainService {

    PaymentEvent validateAndInitiatePayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages);
    PaymentEvent validateAndCancelPayment(Payment payment,
                                          CreditEntry creditEntry,
                                          List<CreditHistory> creditHistories,
                                          List<String> failureMessages);
}
