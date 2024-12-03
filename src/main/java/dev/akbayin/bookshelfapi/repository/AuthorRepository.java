package dev.akbayin.bookshelfapi.repository;

import dev.akbayin.bookshelfapi.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long>, CrudRepository<Author, Long> {
}
