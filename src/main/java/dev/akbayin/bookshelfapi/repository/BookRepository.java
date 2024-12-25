package dev.akbayin.bookshelfapi.repository;

import dev.akbayin.bookshelfapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitleAndPublisherName(String title, String publisherName);
}
