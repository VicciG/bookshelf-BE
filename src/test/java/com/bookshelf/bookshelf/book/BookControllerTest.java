package com.bookshelf.bookshelf.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
public class BookControllerTest {
    @Mock
    BookService service;
    @InjectMocks
    BookController controller;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }
    @Test
    public void shouldCreateBookTable() throws Exception{
        when(service.createBookTable()).thenReturn(1);
        this.mockMvc.perform(post("/book/create")).andDo(print()).andExpect(status().isOk());
        // CHECK RETURN TYPE
    }
    @Test
    public void shouldGetAllBooks() throws Exception{
        List<Book> books = new ArrayList<Book>();
        //books not being added properly??
        Book book = new Book( 1,"test", "test", "test");
        books.add(book);
        when(service.getAllBooks()).thenReturn(books);
        this.mockMvc.perform(get("/book")).andExpect((status().isOk())).andExpect(content().string(containsString(book.getAuthor())));
        //CHECK LIST SIZE AND RETURN TYPE JSON

    }
    @Test
    public void shouldGetBookById() throws Exception{
        Book book = new Book(1, "test", "test", "test");
        when(service.getBookById(1)).thenReturn(book);
        this.mockMvc.perform(get("/book/1")).andExpect((status().isOk())).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
        //CHECK OBJECT EQUALS EXPECTED
    }
    @Test
    public void shouldInsertBook() throws Exception{
        Book book = new Book(1, "test", "test", "test");
        when(service.insertBook(book)).thenReturn(1);
        this.mockMvc.perform(post("/book")
                .content(objectMapper.writeValueAsString(book))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1")));
    }
//CHECKING STATUS, MEDIA TYPE, ACTUAL DATA RETURNED
}
