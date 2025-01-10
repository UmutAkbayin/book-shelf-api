package dev.akbayin.bookshelfapi.mapper;

import dev.akbayin.bookshelfapi.dto.AuthorDto;
import dev.akbayin.bookshelfapi.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
  AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

  Author toModel(AuthorDto authorDto);

  AuthorDto toDto(Author author);
}
