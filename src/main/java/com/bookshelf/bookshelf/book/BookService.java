package com.bookshelf.bookshelf.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    public Book getBookById(int id){
        return bookDao.findBookById(id);
    }


    public List<Book> getBooks() {
        return bookDao.listBooks();
    }

    public int createBook(Book book) {
         return bookDao.insertBook(book);
    }

    public void updateBook(Book book) {
         bookDao.updateBooks(book);
    }

    public void deleteBookById(int id) {
        bookDao.deleteBookById(id);
    }


}
