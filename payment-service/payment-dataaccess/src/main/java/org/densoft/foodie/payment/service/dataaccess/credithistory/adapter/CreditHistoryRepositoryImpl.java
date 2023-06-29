package org.densoft.foodie.payment.service.dataaccess.credithistory.adapter;

import org.densoft.foodie.domain.valueobject.CustomerId;
import org.densoft.foodie.payment.service.dataaccess.credithistory.entity.CreditHistoryEntity;
import org.densoft.foodie.payment.service.dataaccess.credithistory.mapper.CreditHistoryDataAccessMapper;
import org.densoft.foodie.payment.service.dataaccess.credithistory.repository.CreditHistoryJpaRepository;
import org.densoft.foodie.payment.service.domain.entity.CreditHistory;
import org.densoft.foodie.payment.service.domain.ports.output.repository.CreditHistoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CreditHistoryRepositoryImpl implements CreditHistoryRepository {
    private final CreditHistoryJpaRepository creditHistoryJpaRepository;
    private final CreditHistoryDataAccessMapper creditHistoryDataAccessMapper;


    public CreditHistoryRepositoryImpl(CreditHistoryJpaRepository creditHistoryJpaRepository,
                                       CreditHistoryDataAccessMapper creditHistoryDataAccessMapper) {
        this.creditHistoryJpaRepository = creditHistoryJpaRepository;
        this.creditHistoryDataAccessMapper = creditHistoryDataAccessMapper;
    }

    @Override
    public CreditHistory save(CreditHistory creditHistory) {
        return creditHistoryDataAccessMapper.creditHistoryEntityToCreditHistory(creditHistoryJpaRepository
                .save(creditHistoryDataAccessMapper.creditHistoryToCreditHistoryEntity(creditHistory)));
    }

    @Override
    public Optional<List<CreditHistory>> findByCustomerId(CustomerId customerId) {
        Optional<List<CreditHistoryEntity>> creditHistory = creditHistoryJpaRepository.findByCustomerId(customerId.getValue());
        return creditHistory.map(creditHistoryList -> creditHistoryList.stream()
                .map(creditHistoryDataAccessMapper::creditHistoryEntityToCreditHistory)
                .toList());
    }
}
