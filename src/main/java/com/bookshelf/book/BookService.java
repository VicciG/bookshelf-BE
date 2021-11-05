package com.bookshelf.book;

import com.bookshelf.exceptions.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> getAllBooks() throws DataNotFoundException {
        List<Book> books = bookDao.getAllBooks();
        if(books.isEmpty()){
            throw new DataNotFoundException();
        }
        return books;
    }

    public Book getBookById(int id) throws DataNotFoundException{
        Book book = bookDao.getBookById(id);
        if(book == null){
            throw new DataNotFoundException();
        }
        return book;
    }

    public int createBookTable() {
        return bookDao.createTable();
    }

    public int insertBook(Book book) {
        return bookDao.insertBook(book);
    }

    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    public int deleteBookTable(){

        return bookDao.deleteBookTable();
    }

    public int deleteAllBooks() {
        return bookDao.deleteAllBooks();
    }

    public int deleteBookById(int id) {
        return bookDao.deleteBookById(id);
    }

}
