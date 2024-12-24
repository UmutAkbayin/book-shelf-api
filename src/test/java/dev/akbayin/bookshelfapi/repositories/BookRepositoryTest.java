package dev.akbayin.bookshelfapi.repositories;

import dev.akbayin.bookshelfapi.model.Author;
import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.model.Publisher;
import dev.akbayin.bookshelfapi.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveAndFindBook() {
        Book book = new Book();
        Publisher publisher = new Publisher("Test Publisher");
        Author author = new Author();
        author.setFirstName("Test Firstname");
        author.setLastName("Test Lastname");
        Set<Author> authors = new HashSet<>();
        authors.add(author);
        book.setTitle("Test book");
        book.setAuthors(authors);
        book.setPublisher(publisher);
        book.setPublishingYear(2024);

        bookRepository.save(book);
        List<Book> books = bookRepository.findAll();

        // Assert
        assertNotNull(books);
        assertEquals(1, books.size());
        assertEquals("Test book", books.get(0).getTitle());
    }
}
