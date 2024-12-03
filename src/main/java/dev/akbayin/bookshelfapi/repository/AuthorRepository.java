package dev.akbayin.bookshelfapi.repository;

import dev.akbayin.bookshelfapi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
