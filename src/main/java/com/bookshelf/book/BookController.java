package com.bookshelf.book;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getBooks() throws Exception {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) throws Exception{
        return bookService.getBookById(id);
    }


    @GetMapping( "/create")
    public int createBookTable(){

       return bookService.createBookTable();
    }

    @PostMapping()
    public int insertBook(@RequestBody Book book){
        return bookService.insertBook(book);
    }

    @PutMapping()
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @DeleteMapping("/table")
    public void deleteBookTable(){
        bookService.deleteBookTable();
    }

    @DeleteMapping()
    public void deleteAllBooks(){
        bookService.deleteAllBooks();
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable int id){
        bookService.deleteBookById(id);
    }

}
