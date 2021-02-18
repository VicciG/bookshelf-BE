package com.bookshelf.bookshelf.book;

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
    //TODO Complete SQL statements

    @GetGeneratedKeys
    @SqlUpdate
    ("INSERT INTO bookshelf.book(author, title) VALUES (:book.author, :book.title)") // TODO Correct this for your schema
    int insertBook(@BindBean("book") Book book);


    @SqlQuery
    Book findBookById(int id);

    // TODO Correct this for your schema
    @SqlQuery("SELECT * FROM bookshelf.book")
    List<Book> listBooks();

    @SqlUpdate
    void updateBooks(@BindBean Book book);

    @SqlUpdate
    void deleteBookById(int id);
}
