package org.densoft.foodie.order.service.domain.entity;

import org.densoft.foodie.domain.entity.AggregateRoot;
import org.densoft.foodie.domain.value.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {

    public Customer() {
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }
}
