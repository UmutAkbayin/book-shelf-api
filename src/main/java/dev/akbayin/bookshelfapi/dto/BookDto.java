package dev.akbayin.bookshelfapi.dto;

import dev.akbayin.bookshelfapi.model.Author;
import dev.akbayin.bookshelfapi.model.Publisher;
import dev.akbayin.bookshelfapi.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class BookDto {

    private String title;
    private Set<Author> authors;
    private Publisher publisher;
    private int publishingYear;
    private Status status = Status.NOT_READ;
}
