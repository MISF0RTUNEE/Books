package com.books.Books.Controllers;
import com.books.Books.Entity.books;
import com.books.Books.Repository.BooksRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/")
public class MainController {

    private final BooksRepository repository;
    MainController(BooksRepository repository){
        this.repository = repository;
    }
    @GetMapping("/all")
    public List<books> getAll(){
        return repository.findAll();
    }


    @GetMapping("isbn/{isbn}")
    public books getBook(@PathVariable int isbn){
        return repository.findByIsbn(isbn);
    }


    @PostMapping
    public books addBook(@RequestBody books newBook){
        return repository.save(newBook);
    }


    @PutMapping
    public books updateBook(@RequestBody books newBook){
       repository.findByIsbn(newBook.getIsbn()).setTitle(newBook.getTitle());
       return repository.save(repository.findByIsbn(newBook.getIsbn()));


    }


    @DeleteMapping("isbn/{isbn}")
    @Transactional
    public void deleteBook(@PathVariable int isbn){
        repository.deleteByIsbn(isbn);
    }
}
