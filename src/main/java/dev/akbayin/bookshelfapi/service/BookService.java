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
        Optional<Book> existingBook = bookRepository.findByTitleAndPublisherName(
                bookDto.getTitle(), bookDto.getPublisher().getName()
        );
        if (existingBook.isPresent()) {
            throw new IllegalArgumentException("A book with the same title already exists.");
        }
        Book newBook = new Book();
        newBook.setTitle(bookDto.getTitle());
        newBook.setStatus(bookDto.getStatus());
        newBook.setPublishingYear(bookDto.getPublishingYear());
        newBook.setAuthors(bookDto.getAuthors());
        newBook.setPublisher(bookDto.getPublisher());

        return Optional.of(bookRepository.save(newBook));
    }
}
