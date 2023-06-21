package org.densoft.foodie.order.service.dataaccess.customer.mapper;

import org.densoft.foodie.domain.value.CustomerId;
import org.densoft.foodie.order.service.dataaccess.customer.entity.CustomerEntity;
import org.densoft.foodie.order.service.domain.entity.Customer;

public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }
}
