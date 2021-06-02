package com.bookshelf.book;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RegisterBeanMapper(Book.class)
public interface BookDao {

    @SqlQuery("SELECT * FROM book")
    List<Book> getAllBooks();

    @SqlQuery("SELECT * FROM book WHERE id = :id ")
    Book getBookById(int id);

    @SqlUpdate("CREATE TABLE book (id SERIAL PRIMARY KEY, title VARCHAR, author VARCHAR, colour VARCHAR)")
    int createTable();

    @SqlUpdate("INSERT INTO book(title, author, colour) VALUES (:title, :author, :colour)")
    @GetGeneratedKeys("id")
    int insertBook(@BindBean Book book);

    @SqlUpdate("UPDATE book SET title = :title, author = :author, colour = :colour WHERE id = :id")
    int updateBook(@BindBean Book book);

    @SqlUpdate("DROP TABLE book")
    int deleteBookTable();

    @SqlUpdate("DELETE FROM book")
    int deleteAllBooks();

    @SqlUpdate("DELETE FROM book WHERE id = ?")
    int deleteBookById(int id);

}
