package dev.akbayin.bookshelfapi.service;

import dev.akbayin.bookshelfapi.dto.BookDto;
import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> createBook(BookDto bookDto) {
        throw new UnsupportedOperationException();
    }
}
