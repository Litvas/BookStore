package org.litvas.bookstore.dto;

import org.litvas.bookstore.domain.Book;

import java.math.BigDecimal;

public record PurchaseItemDTO
        (
                Book book, Long quantity, BigDecimal unitPrice

        ) {
}
