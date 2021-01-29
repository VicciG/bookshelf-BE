package com.bookshelf.bookshelf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookshelfController {
    @GetMapping("/name/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello " + name;
    }
}

// TO DO
// Set up angular project
//set up api endpoints here
//get db working, alternatively setup localdb
