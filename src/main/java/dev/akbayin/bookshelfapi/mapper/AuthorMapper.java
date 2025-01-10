package dev.akbayin.bookshelfapi.mapper;

import dev.akbayin.bookshelfapi.dto.PublisherDto;
import dev.akbayin.bookshelfapi.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
  AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

  Publisher toModel(PublisherDto publisherDto);

  Publisher toDto(Publisher publisher);
}
