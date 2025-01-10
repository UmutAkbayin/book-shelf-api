package dev.akbayin.bookshelfapi.mapper;

import dev.akbayin.bookshelfapi.model.Book;
import dev.akbayin.bookshelfapi.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AuthorMapper.class, PublisherMapper.class})
public interface BookMapper {
  BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

  Book toModel(BookDto bookDto);

  BookDto toDto(Book book);
}