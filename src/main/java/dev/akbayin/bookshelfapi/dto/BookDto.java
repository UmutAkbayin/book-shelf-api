package dev.akbayin.bookshelfapi.dto;

import dev.akbayin.bookshelfapi.model.Status;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor(force = true)
@Getter
public class BookDto {

    @NotNull
    @Size(min = 1, max = 255)
    private final String title;

    @NotEmpty
    private final Set<Long> authorIds;

    @NotNull
    private final Long publisherId;

    @Positive
    private final int publishingYear;

    @NotNull
    private final Status status;

    public BookDto(String title, Set<Long> authorIds, Long publisherId, int publishingYear, Status status) {
        this.title = title;
        this.authorIds = authorIds;
        this.publisherId = publisherId;
        this.publishingYear = publishingYear;
        this.status = status != null ? status : Status.NOT_READ; // Ensure default
    }
}