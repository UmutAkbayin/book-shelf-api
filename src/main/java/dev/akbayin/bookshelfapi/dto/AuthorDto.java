package dev.akbayin.bookshelfapi.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Getter
public class AuthorDto {
  private final Long id;

  @NotNull
  @Size(min = 1, max = 255)
  private final String firstName;

  @NotNull
  @Size(min = 1, max = 255)
  private final String lastName;


  public AuthorDto(Long id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
