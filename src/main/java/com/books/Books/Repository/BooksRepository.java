package com.books.Books.Repository;

import com.books.Books.Entity.books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<books, Long> {
    books findByIsbn(int isbn);
    void deleteByIsbn(int isbn);
}
