package com.bookshelf.bookshelf.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //TODO - Add HTTP Response codes to each endpoint

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @GetMapping()
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBookById(id);
    }

    @PostMapping()
    public int createBook(@RequestBody Book book){
         return bookService.createBook(book);
    }

    @PutMapping()
    public void updateBook(@RequestBody Book book){
         bookService.updateBook(book);
    }
}
