package dev.akbayin.bookshelfapi.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import dev.akbayin.bookshelfapi.model.Publisher;
import dev.akbayin.bookshelfapi.repository.PublisherRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class PublisherReferenceConverter extends StdConverter<String, Publisher> {

    private final PublisherRepository publisherRepository;

    public PublisherReferenceConverter(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher convert(String publisherPath) {
        long publisherId = Long.parseLong(publisherPath.split("/")[2]);
        return publisherRepository.findById(publisherId)
                .orElseThrow(() -> new EntityNotFoundException("Publisher not found"));
    }
}
