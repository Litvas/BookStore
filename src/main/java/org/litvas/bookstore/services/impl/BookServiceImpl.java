package org.litvas.bookstore.services.impl;

import lombok.RequiredArgsConstructor;
import org.litvas.bookstore.domain.Book;
import org.litvas.bookstore.domain.BookAvailability;
import org.litvas.bookstore.dto.BookDTO;
import org.litvas.bookstore.mappers.BookMapper;
import org.litvas.bookstore.repositories.BookRepository;
import org.litvas.bookstore.services.BookService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDTO> getAvailableBooks(PageRequest pageRequest) {
        List<Book> books = bookRepository.findAllByAvailability(BookAvailability.AVAILABLE, pageRequest);
        return bookMapper.toBookDtoList(books);
    }

    @Override
    public Optional<Book> getBookById(UUID id) {
        return bookRepository.findById(id);
    }

}
