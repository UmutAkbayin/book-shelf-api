package dev.akbayin.bookshelfapi.service;

import dev.akbayin.bookshelfapi.dto.BookDto;
import dev.akbayin.bookshelfapi.exception.DuplicateBookException;
import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> createBook(BookDto bookDto) {
        Optional<Book> existingBook = bookRepository.findByTitleAndPublisherName(
                bookDto.getTitle(), bookDto.getPublisher().getName()
        );
        if (existingBook.isPresent()) {
            throw new DuplicateBookException();
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
