package com.bookshelf.bookshelf;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    private int bookId;
    private String title;
    private String author;
    private String colour;

    public Book(String title, String author, String colour) {
        this.title = title;
        this.author = author;
        this.colour = colour;
    }

}
