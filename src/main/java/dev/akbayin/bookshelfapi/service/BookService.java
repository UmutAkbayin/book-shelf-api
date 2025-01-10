package dev.akbayin.bookshelfapi.service;

import dev.akbayin.bookshelfapi.dto.BookDto;
import dev.akbayin.bookshelfapi.exception.BookVersionMismatchException;
import dev.akbayin.bookshelfapi.exception.DuplicateBookException;
import dev.akbayin.bookshelfapi.exception.InvalidBookArgumentException;
import dev.akbayin.bookshelfapi.mapper.BookMapper;
import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.repository.BookRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(BookDto bookDto) {
        Book newBook = bookMapper.toModel(bookDto);

        try {
            return bookRepository.save(newBook);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateBookException("Book with the title already exists.");
        } catch (OptimisticLockingFailureException ex) {
            throw new BookVersionMismatchException("The book version is outdated or entity does not exist.");
        } catch (IllegalArgumentException e) {
            throw new InvalidBookArgumentException();
        }
    }
}
