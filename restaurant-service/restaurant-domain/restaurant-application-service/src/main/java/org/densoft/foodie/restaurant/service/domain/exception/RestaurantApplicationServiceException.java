package org.densoft.foodie.restaurant.service.domain.exception;

import org.densoft.foodie.domain.exception.DomainException;

public class RestaurantApplicationServiceException extends DomainException {

    public RestaurantApplicationServiceException(String message) {
        super(message);
    }

    public RestaurantApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
