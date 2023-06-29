package org.densoft.foodie.payment.service.domain.valueobject;

import org.densoft.foodie.domain.valueobject.BaseId;

import java.util.UUID;

public class PaymentId extends BaseId<UUID> {
    public PaymentId(UUID value) {
        super(value);
    }
}
