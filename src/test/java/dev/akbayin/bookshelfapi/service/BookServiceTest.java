package dev.akbayin.bookshelfapi.service;

import dev.akbayin.bookshelfapi.dto.BookDto;
import dev.akbayin.bookshelfapi.model.Author;
import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.model.Publisher;
import dev.akbayin.bookshelfapi.model.Status;
import dev.akbayin.bookshelfapi.repository.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
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

    @Test
    @DisplayName("Create a new Book that does not exist")
    public void testCreateBook() {
        // Arrange
        BookDto bookDto = new BookDto();
        bookDto.setTitle("Spring Security in Action");
        bookDto.setPublishingYear(2024);
        bookDto.setStatus(Status.NOT_READ);
        bookDto.setPublisher(new Publisher("Manning"));
        bookDto.setAuthors(Set.of(new Author("Laurentiu", "Spilca")));

        Book book = new Book();
        book.setTitle("Spring Security in Action");
        book.setPublishingYear(2024);
        book.setStatus(Status.NOT_READ);
        book.setPublisher(new Publisher("Manning"));
        book.setAuthors(Set.of(new Author("Laurentiu", "Spilca")));

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // Act
        Optional<Book> savedBook = bookService.createBook(bookDto);

        // Assert
        assertTrue(savedBook.isPresent());
        assertEquals("Spring Security in Action", savedBook.get().getTitle());
        assertEquals("Manning", savedBook.get().getPublisher().getName());
        assertTrue(savedBook.get().getAuthors().stream()
                .anyMatch(author -> author.getFirstName().equals("Laurentiu")
                        && author.getLastName().equals("Spilca")));
        verify(bookRepository, times(1)).save(any(Book.class));
    }
}
