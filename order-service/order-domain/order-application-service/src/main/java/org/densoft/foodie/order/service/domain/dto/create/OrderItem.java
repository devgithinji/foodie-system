package org.densoft.foodie.order.service.domain.dto.create;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderItem {
    @NonNull
    private final UUID productId;
    @NonNull
    private final Integer quantity;
    @NonNull
    private final BigDecimal price;
    @NonNull
    private final BigDecimal subTotal;
}
