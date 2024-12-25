package dev.akbayin.bookshelfapi.controller;

import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("books")
    ResponseEntity<Book> createBook() {
        throw new UnsupportedOperationException();
    }
}
