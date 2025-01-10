package dev.akbayin.bookshelfapi.service;

import dev.akbayin.bookshelfapi.dto.AuthorDto;
import dev.akbayin.bookshelfapi.dto.BookDto;
import dev.akbayin.bookshelfapi.dto.PublisherDto;
import dev.akbayin.bookshelfapi.exception.DuplicateBookException;
import dev.akbayin.bookshelfapi.model.Author;
import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.model.Publisher;
import dev.akbayin.bookshelfapi.model.Status;
import dev.akbayin.bookshelfapi.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private BookDto bookDto;
    private Book book;

    @BeforeEach
    public void setUp() {
        String title = "Spring Security in Action";
        Set<AuthorDto> authors = Set.of(new AuthorDto("Laurentiu", "Spilca"));
        PublisherDto publisher = new PublisherDto("Manning");
        int publishingYear = 2024;
        Status status = Status.NOT_READ;
        bookDto = new BookDto(
          title,
          authors,
          publisher,
          publishingYear,
          status
        );

        book = new Book();
        book.setTitle("Spring Security in Action");
        book.setPublishingYear(2024);
        book.setStatus(Status.NOT_READ);
        book.setPublisher(new Publisher("Manning"));
        book.setAuthors(Set.of(new Author("Laurentiu", "Spilca")));
    }

    @Test
    @DisplayName("Create a new Book that does not exist")
    public void testCreateBook() {

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book savedBook = bookService.createBook(bookDto);

        assertEquals("Spring Security in Action", savedBook.getTitle());
        assertEquals("Manning", savedBook.getPublisher().getName());
        assertTrue(savedBook.getAuthors().stream()
                .anyMatch(author -> author.getFirstName().equals("Laurentiu")
                        && author.getLastName().equals("Spilca")));
        verify(bookRepository, times(1)).save(any(Book.class));
    }

    @Test
    @DisplayName("Throw DuplicateBookException when a book with the same title and publisher name exists")
    void testCreateDuplicateBookByPublisherName() {
        // Arrange
        when(bookRepository.save(any(Book.class)))
                .thenThrow(new DataIntegrityViolationException("Duplicate entry"));

        // Act & Assert
        assertThrows(DuplicateBookException.class, () -> bookService.createBook(bookDto));

        // Verify
        verify(bookRepository, times(1)).save(any(Book.class));
    }
}
