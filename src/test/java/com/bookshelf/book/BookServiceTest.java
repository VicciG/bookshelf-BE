package com.bookshelf.book;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {
    BookDao dao;
    BookService service;

    @Before
    public void init(){
        dao = Mockito.mock(BookDao.class);
        service = new BookService(dao);
    }
    //check sizes of lists
    @Test
    public void getAllBooksTest(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "test", "test", "test"));
        Mockito.when(dao.getAllBooks()).thenReturn(books);

        List<Book> result = this.service.getAllBooks();
        Assert.assertEquals(books, result);
    }

    @Test
    public void getBookByIdTest(){
        Book book = new Book(1, "test", "test", "test");
        Mockito.when(dao.getBookById(1)).thenReturn(book);
        Book result = this.service.getBookById(1);
        Assert.assertEquals(book, result);
    }

    @Test
    public void createBookTableTest(){
        Mockito.when(dao.createTable()).thenReturn(1);

        int result = this.service.createBookTable();
        Assert.assertEquals(1, result);

    }

    @Test
    public void insertBookTest(){
        int id = 1;
        Book book = new Book(1, "test", "test", "test");
        Mockito.when(dao.insertBook(book)).thenReturn(id);

        int result = this.service.insertBook(book);
        Assert.assertEquals(id, result);

    }

    @Test
    public void updateBookTest(){
        int id = 1;
        Book book = new Book(1, "test", "test", "test");
        Mockito.when(dao.updateBook(book)).thenReturn(id);

        int result = this.service.updateBook(book);
        Assert.assertEquals(id, result);

    }

    @Test
    public void deleteBookTableTest(){
        Mockito.when(dao.deleteBookTable()).thenReturn(1);

        int result = this.service.deleteBookTable();
        Assert.assertEquals(1, result);

    }

    @Test
    public void deleteAllBooksTest(){
        Mockito.when(dao.deleteAllBooks()).thenReturn(1);

        int result = this.service.deleteAllBooks();
        Assert.assertEquals(1, result);

    }

    @Test
    public void deleteBookByIdTest(){
        Mockito.when(dao.deleteBookById(1)).thenReturn(1);

        int result = this.service.deleteBookById(1);
        Assert.assertEquals(1, result);

    }
}
