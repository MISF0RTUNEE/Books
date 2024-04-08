package com.books.Books.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "books")
public class books {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private int isbn;
    private String title;

    public books(){

    }

    public books(int isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
