package dev.akbayin.bookshelfapi.repository;

import dev.akbayin.bookshelfapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
