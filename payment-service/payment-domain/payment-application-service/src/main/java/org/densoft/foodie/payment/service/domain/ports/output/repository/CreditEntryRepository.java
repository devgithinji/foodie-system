package org.densoft.foodie.payment.service.domain.ports.output.repository;

import org.densoft.foodie.domain.valueobject.CustomerId;
import org.densoft.foodie.payment.service.domain.entity.CreditEntry;

import java.util.Optional;

public interface CreditEntryRepository {

    CreditEntry save(CreditEntry creditEntry);

    Optional<CreditEntry> findByCustomerId(CustomerId customerId);
}
