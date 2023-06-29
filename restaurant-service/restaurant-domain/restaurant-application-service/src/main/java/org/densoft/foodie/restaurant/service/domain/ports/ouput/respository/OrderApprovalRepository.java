package org.densoft.foodie.restaurant.service.domain.ports.ouput.respository;

import org.densoft.foodie.retaurant.service.domain.entity.OrderApproval;

public interface OrderApprovalRepository {
    OrderApproval save(OrderApproval orderApproval);
}
