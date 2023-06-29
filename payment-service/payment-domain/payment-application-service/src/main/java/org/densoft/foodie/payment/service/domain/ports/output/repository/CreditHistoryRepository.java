package org.densoft.foodie.payment.service.domain.ports.output.repository;

import org.densoft.foodie.domain.valueobject.CustomerId;
import org.densoft.foodie.payment.service.domain.entity.CreditHistory;

import java.util.List;
import java.util.Optional;

public interface CreditHistoryRepository {
    CreditHistory save(CreditHistory creditHistory);

    Optional<List<CreditHistory>> findByCustomerId(CustomerId customerId);
}
