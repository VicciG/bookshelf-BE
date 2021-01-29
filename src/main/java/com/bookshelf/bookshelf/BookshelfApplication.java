package com.bookshelf.bookshelf;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BookshelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookshelfApplication.class, args);
        try {
            Jdbi jdbi = Jdbi.create("jdbc:postgresql://bookshelfdb.cbktbt3i6mfv.eu-west-2.rds.amazonaws.com:5433/postgres?user=postgres&password=kYIAgWW5VZYT54Et9zDo");
            Handle h = jdbi.open();
            //h.execute("CREATE TABLE book (bookId INTEGER PRIMARY KEY, title VARCHAR, author VARCHAR, colour VARCHAR)");
            h.execute("INSERT INTO book VALUES (?, ?, ?, ?)", 4, "Roald Dahl", "The Twits", "Green");

           /* List<Book> list = h.createQuery("SELECT title, author FROM book").map(new BookMapper()).list();

            for (Book a : list) {
                System.out.println("Title: " + a.getTitle() + " Author: " + a.getAuthor());
            }*/

            h.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
