package com.bookshelf.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Category;
import com.bookshelf.demo.services.BookService;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService service;

    @GetMapping("/allbooks")
    public List<Book> getAllBooks(){
        List<Book> library = service.getLibrary();
        return library;
    }

    @GetMapping("/category")
    public List<Book> booksFromCategory(@RequestBody Category category){
        return service.getBookByCategory(category);
    }

    @GetMapping("/book")
    public Book getBookFromId(@RequestParam(value = "id") int id){
        return service.getBookById(id);
    }

    

}
