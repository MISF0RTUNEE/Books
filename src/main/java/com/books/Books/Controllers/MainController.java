package com.books.Books.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MainController {
    Map<Integer, String> books = new HashMap<Integer, String>(){
        {
            put(1, "123");
            put(2, "456");
            put(3, "789");
        }
    };


    @GetMapping("/all")
    public Map<Integer, String> getBooks(){
        return books;
    }

    @GetMapping("isbn/{isbn}")
    public Map<Integer, String> getBook(@PathVariable int isbn){
        String title = books.get(isbn);
        Map<Integer, String> book = new HashMap<Integer, String>();
        book.put(isbn, title);
        return book;
    }

    @PostMapping
    public Map<Integer, String> addBook(@RequestBody Map<Integer, String> book){
        books.putAll(book);
        return books;
    }

    @PutMapping("isbn/{isbn}")
    public Map<Integer, String> updateBook(@RequestBody Map<Integer, String> book, @PathVariable int isbn){
        if (books.containsKey(isbn)){
            books.putAll(book);
        }
        return books;
    }

    @DeleteMapping("isbn/{isbn}")
    public void delete(@PathVariable int isbn){
        books.remove(isbn);
    }
}
