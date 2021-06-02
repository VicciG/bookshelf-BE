package com.bookshelf.book;

import java.util.List;

public interface BookServiceInterface {

    List<Book> getAllBooks() throws Exception;

    Book getBookById(int id);

    int createBookTable();

    int insertBook(Book book);

    int updateBook(Book book);

    int deleteBookTable();

    int deleteAllBooks();

    int deleteBookById(int id);


}
