package org.litvas.bookstore.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PurchaseDTO
        (
                UUID id,
                BigDecimal totalPrice,
                LocalDateTime createdAt,
                List<PurchaseItemDTO> items
        ) {
}
