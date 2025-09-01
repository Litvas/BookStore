package org.litvas.bookstore.dto;

import org.litvas.bookstore.domain.BookType;

import java.math.BigDecimal;
import java.util.UUID;

public record BookDTO
        (UUID id,
         String title,
         BookType type,
         BigDecimal price) {
}
