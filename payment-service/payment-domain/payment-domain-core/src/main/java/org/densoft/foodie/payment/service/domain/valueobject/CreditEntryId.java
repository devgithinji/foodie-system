package org.densoft.foodie.payment.service.domain.valueobject;

import org.densoft.foodie.domain.valueobject.BaseId;

import java.util.UUID;

public class CreditEntryId extends BaseId<UUID> {
    public CreditEntryId(UUID value) {
        super(value);
    }
}
