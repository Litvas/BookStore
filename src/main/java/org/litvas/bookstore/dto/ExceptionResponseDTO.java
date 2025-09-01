package org.litvas.bookstore.dto;

public record ExceptionResponseDTO
        (String code,
         String status,
         String message
        ) {
}
