package org.litvas.bookstore.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @Enumerated(EnumType.STRING)
    private BookType type;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private BookAvailability availability;

}
