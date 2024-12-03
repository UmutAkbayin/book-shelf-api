package dev.akbayin.bookshelfapi.repository;

import dev.akbayin.bookshelfapi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
