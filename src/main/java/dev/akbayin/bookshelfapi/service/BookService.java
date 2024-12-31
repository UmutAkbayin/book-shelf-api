package dev.akbayin.bookshelfapi.service;

import dev.akbayin.bookshelfapi.dto.BookDto;
import dev.akbayin.bookshelfapi.exception.BookVersionMismatchException;
import dev.akbayin.bookshelfapi.exception.DuplicateBookException;
import dev.akbayin.bookshelfapi.exception.InvalidBookArgumentException;
import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.repository.BookRepository;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(BookDto bookDto) {
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

        try {
            return bookRepository.save(newBook);
        } catch (OptimisticLockingFailureException ex) {
            throw new BookVersionMismatchException("The book version is outdated or entity does not exist.");
        }catch (IllegalArgumentException e) {
            throw new InvalidBookArgumentException();
        }
    }
}
