package dev.akbayin.bookshelfapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    private String title;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "book_authors",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @Getter
    @Setter
    private Set<Author> authors = new HashSet<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publisher_id", nullable = false)
    @NotNull
    @Getter
    @Setter
    private Publisher publisher;

    @Getter
    @Setter
    @Column(name = "publishing_year")
    private int publishingYear;

    @Column(columnDefinition = "ENUM('READ', 'WANT_TO_READ', 'READING', 'NOT_READ')")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Status status;
}
