package org.densoft.foodie.payment.service.domain.valueobject;

import org.densoft.foodie.domain.value.BaseId;

import java.util.UUID;

public class CreditHistoryId extends BaseId<UUID> {
    public CreditHistoryId(UUID value) {
        super(value);
    }
}
