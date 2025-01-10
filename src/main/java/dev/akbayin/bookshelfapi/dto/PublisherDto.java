package dev.akbayin.bookshelfapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Getter
public class PublisherDto {
  private Long id;

  @NotNull
  @Size(min = 1, max = 255)
  private final String name;

  public PublisherDto(String name) {
    this.name = name;
  }

  public PublisherDto(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
