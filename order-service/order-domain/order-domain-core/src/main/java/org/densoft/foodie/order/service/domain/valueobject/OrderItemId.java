package org.densoft.foodie.order.service.domain.valueobject;

import org.densoft.foodie.domain.value.BaseId;

public class OrderItemId extends BaseId<Long> {

    protected OrderItemId(Long value) {
        super(value);
    }
}
