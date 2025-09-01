package org.litvas.bookstore.controllers;

import lombok.RequiredArgsConstructor;
import org.litvas.bookstore.dto.BookDTO;
import org.litvas.bookstore.services.BookService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDTO> getBooks(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value ="size", defaultValue = "10") int size) {
        return bookService.getAvailableBooks(PageRequest.of(page, size));
    }

}
