package dev.akbayin.bookshelfapi.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import dev.akbayin.bookshelfapi.model.Publisher;
import dev.akbayin.bookshelfapi.repository.PublisherRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublisherReferenceConverter extends StdConverter<String, Publisher> {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Publisher convert(String publisherPath) {
        long publisherId = Long.parseLong(publisherPath.split("/")[2]);
        return publisherRepository.findById(publisherId)
                .orElseThrow(() -> new EntityNotFoundException("Publisher not found"));
    }
}
