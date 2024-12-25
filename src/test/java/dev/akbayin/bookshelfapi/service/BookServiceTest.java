package dev.akbayin.bookshelfapi.service;

import dev.akbayin.bookshelfapi.model.Author;
import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.model.Publisher;
import dev.akbayin.bookshelfapi.model.Status;
import dev.akbayin.bookshelfapi.repository.BookRepository;
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
    public void testCreateBook() {
        Book book = new Book();
        Publisher publisher = new Publisher("Manning");
        Author author = new Author();
        author.setFirstName("Laurentiu");
        author.setLastName("Spilca");
        Set<Author> authors = new HashSet<>();
        authors.add(author);
        book.setAuthors(authors);
        book.setPublisher(publisher);
        book.setTitle("Spring Security in Action");
        book.setPublishingYear(2024);
        book.setStatus(Status.NOT_READ);

        when(bookRepository.save(any(Book.class))).thenReturn(book);



        bookService.createBook().ifPresent((savedBook) -> {
            assertNotNull(savedBook);
            assertEquals("Spring Security in Action", savedBook.getTitle());
            assertTrue(savedBook.getAuthors().contains(author));
            verify(bookRepository, times(1)).save(book);
        });
    }
}
