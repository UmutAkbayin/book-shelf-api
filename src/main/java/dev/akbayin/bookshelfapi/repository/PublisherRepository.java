package dev.akbayin.bookshelfapi.repository;

import dev.akbayin.bookshelfapi.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
