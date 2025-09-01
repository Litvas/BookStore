package org.litvas.bookstore.mappers;

import org.litvas.bookstore.domain.Book;
import org.litvas.bookstore.dto.BookDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Named("toBookDTO")
    BookDTO toBookDTO(Book book);

    @IterableMapping(qualifiedByName = "toBookDTO")
    List<BookDTO> toBookDtoList(List<Book> bookList);

}
