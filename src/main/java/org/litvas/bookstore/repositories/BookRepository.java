package org.litvas.bookstore.repositories;

import org.litvas.bookstore.domain.Book;
import org.litvas.bookstore.domain.BookAvailability;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

    List<Book> findAllByAvailability(BookAvailability availability, Pageable pageable);
}
