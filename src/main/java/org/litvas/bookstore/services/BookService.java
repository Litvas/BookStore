package org.litvas.bookstore.services;

import org.litvas.bookstore.domain.Book;
import org.litvas.bookstore.dto.BookDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    List<BookDTO> getAvailableBooks(PageRequest pageRequest);

    Optional<Book> getBookById(UUID id);

}
