package dev.akbayin.bookshelfapi.repository;

import dev.akbayin.bookshelfapi.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>, CrudRepository<Book, Long> {
}
