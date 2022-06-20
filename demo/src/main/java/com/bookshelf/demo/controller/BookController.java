package com.bookshelf.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Category;
import com.bookshelf.demo.services.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("http://localhost:3000")
public class BookController {
    
    @Autowired
    public BookService bookService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping("/Books")
    public List<Book> getAllBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/Book")
    public Book getBookId(@RequestParam(value = "id") Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/fantasyBooks")
    public List<Book> getFantasyBooks(){
        return bookService.getFantasyBooks();
    }

    @GetMapping("/horrorBooks")
    public List<Book> getHorrorBooks(){
        return bookService.getHorrorBooks();
    }

    @GetMapping("/scifi")
    public List<Book> getSciFi(){
        return bookService.getSciFiBooks();
    }


    @DeleteMapping("/deleteBook")
    public String deleteRider(@RequestParam (value = "id") Long id){
        return bookService.deleteBookById(id);
    }

    @GetMapping("/bookTitle")
    public Optional<Book> getBookTitle(@RequestParam(value = "title") String title){
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/categories")
    public List<Category> allCategories(){
        return bookService.getAllCategories();
    }

}
