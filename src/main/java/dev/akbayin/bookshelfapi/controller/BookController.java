package dev.akbayin.bookshelfapi.controller;

import dev.akbayin.bookshelfapi.dto.BookDto;
import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.net.URI;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Create a new book")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Book created",
        content = { @Content(mediaType = "application/json",
          schema = @Schema(implementation = Book.class)) }),
    })
    @PostMapping("books")
    ResponseEntity<Book> createBook(@RequestBody @Valid BookDto bookDto, UriComponentsBuilder ucb) {
        Book savedBook = bookService.createBook(bookDto);
        URI locationOfNewBook = ucb
                .path("/api/books/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewBook).body(savedBook);
    }
}
