package org.densoft.foodie.restaurant.service.dataaccess.restaurant.repository;

import org.densoft.foodie.restaurant.service.dataaccess.restaurant.entity.OrderApprovalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderApprovalJpaRepository extends JpaRepository<OrderApprovalEntity, UUID> {

}
