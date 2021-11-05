package com.bookshelf.book;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
public class IntegrationTest {
    public Jdbi jdbi;

    @Before
    public void setup() {
        jdbi = jdbi.create("jdbc:h2:mem:test");
        jdbi.installPlugin(new SqlObjectPlugin());
    }
    @Test
    public void ShouldGetBookById() {
        Book book1 = new Book(1, "Alice", "Wonderland", "Red");
        Book book2 = new Book(2, "Charles", "Oliver", "Blue");
        List<Book> returnedBooks = jdbi.withExtension(BookDao.class, dao -> {

            dao.createTable();

            dao.insertBook(book1);
            dao.insertBook(book2);

            return dao.getAllBooks();
        });

        assertThat(returnedBooks).containsExactly(book1, book2);
    }

    @Test
    public void ShouldGetAllBooks() {
        Book book1 = new Book(1, "Alice", "Wonderland", "Red");
        Book returnedBook = jdbi.withExtension(BookDao.class, dao -> {

            dao.createTable();

            dao.insertBook(book1);

            return dao.getBookById(1);
        });

        assertThat(returnedBook).isEqualTo(book1);
    }

    @Test
    public void ShouldDeleteBookById() {
        Book book1 = new Book(1, "Alice", "Wonderland", "Red");
        Book book2 = new Book(2, "Charles", "Oliver", "Blue");
        List<Book> returnedBooks = jdbi.withExtension(BookDao.class, dao -> {

            dao.createTable();

            dao.insertBook(book1);
            dao.insertBook(book2);
            dao.deleteBookById(1);

            return dao.getAllBooks();
        });

        assertThat(returnedBooks).containsExactly(book2);
    }

    @Test
    public void ShouldDeleteAllBooks() {
        Book book1 = new Book(1, "Alice", "Wonderland", "Red");
        Book book2 = new Book(2, "Charles", "Oliver", "Blue");
        List<Book> returnedBooks = jdbi.withExtension(BookDao.class, dao -> {

            dao.createTable();

            dao.insertBook(book1);
            dao.insertBook(book2);
            dao.deleteAllBooks();

            return dao.getAllBooks();
        });

        assertThat(returnedBooks).isEmpty();
    }

}
