package com.bookshelf.bookshelf;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BookMapper implements RowMapper<Book> {
    @Override
    public Book map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Book(rs.getString("title"), rs.getString("author"), rs.getString("colour"));
    }
}
