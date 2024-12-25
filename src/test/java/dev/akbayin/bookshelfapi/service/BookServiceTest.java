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
        BookDto bookDto = new BookDto();
        Publisher publisher = new Publisher("Manning");
        Author author = new Author();
        author.setFirstName("Laurentiu");
        author.setLastName("Spilca");
        Set<Author> authors = new HashSet<>();
        authors.add(author);
        bookDto.setAuthors(authors);
        bookDto.setPublisher(publisher);
        bookDto.setTitle("Spring Security in Action");
        bookDto.setPublishingYear(2024);
        bookDto.setStatus(Status.NOT_READ);

        Book book = new Book();
        Publisher otherPublisher = new Publisher("Manning");
        Author otherAuthor = new Author();
        otherAuthor.setFirstName("Laurentiu");
        otherAuthor.setLastName("Spilca");
        Set<Author> otherAuthors = new HashSet<>();
        otherAuthors.add(otherAuthor);
        book.setAuthors(otherAuthors);
        book.setPublisher(otherPublisher);
        book.setTitle("Spring Security in Action");
        book.setPublishingYear(2024);
        book.setStatus(Status.NOT_READ);

        when(bookRepository.save(any(Book.class))).thenReturn(book);



        bookService.createBook(bookDto).ifPresent((savedBook) -> {
            assertNotNull(savedBook);
            assertEquals("Spring Security in Action", savedBook.getTitle());
            assertTrue(savedBook.getAuthors().contains(otherAuthor));
        });
        verify(bookRepository, times(1)).save(any(Book.class));
    }
}
