package org.densoft.foodie.retaurant.service.domain.valueobject;

import org.densoft.foodie.domain.value.BaseId;

import java.util.UUID;

public class OrderApprovalId extends BaseId<UUID> {
    public OrderApprovalId(UUID value) {
        super(value);
    }
}
