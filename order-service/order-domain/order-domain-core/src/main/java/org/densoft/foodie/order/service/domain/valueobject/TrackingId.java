package org.densoft.foodie.order.service.domain.valueobject;

import org.densoft.foodie.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
