package com.bookshelf.bookshelf.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class Book {

    private int id;
    private String author;
    private String title;
    private String colour;


}
