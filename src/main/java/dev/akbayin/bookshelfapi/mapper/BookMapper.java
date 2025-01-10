package dev.akbayin.bookshelfapi.mapper;

import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
  BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

  @Mapping(source = "publisherId", target = "publisher.id")
  Book toModel(BookDto bookDto);

  @Mapping(source = "publisher.id", target = "publisherId")
  BookDto toDto(Book book);
}