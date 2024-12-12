package dev.akbayin.bookshelfapi;

import dev.akbayin.bookshelfapi.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookShelfApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void shouldReturnBooks() throws Exception {
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAuthors() throws Exception {
        mockMvc.perform(get("/api/authors"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnPublisher() throws Exception {
        mockMvc.perform(get("/api/publishers"))
                .andExpect(status().isOk());
    }

}
