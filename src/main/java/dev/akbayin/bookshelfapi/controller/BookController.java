package dev.akbayin.bookshelfapi.controller;

import dev.akbayin.bookshelfapi.dto.BookDto;
import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("books")
    ResponseEntity<Book> createBook(@RequestBody BookDto bookDto, UriComponentsBuilder ucb) {
        Optional<Book> bookOptional = bookService.createBook(bookDto);
        if (bookOptional.isPresent()) {
            Book savedBook = bookOptional.get();
            URI locationOfNewBook = ucb
                    .path("/api/books/{id}")
                    .buildAndExpand(savedBook.getId())
                    .toUri();
            return ResponseEntity.created(locationOfNewBook).build();
        }
        return ResponseEntity.badRequest().build();
    }
}
