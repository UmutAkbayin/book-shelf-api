package dev.akbayin.bookshelfapi.mapper;

import dev.akbayin.bookshelfapi.dto.PublisherDto;
import dev.akbayin.bookshelfapi.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherMapper {
  PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

  Publisher toModel(PublisherDto publisherDto);

  PublisherDto toDto(Publisher publisher);
}
