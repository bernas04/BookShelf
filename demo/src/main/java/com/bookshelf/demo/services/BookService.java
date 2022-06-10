package com.bookshelf.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Category;
import com.bookshelf.demo.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository repository;

    public List<Book> getLibrary(){
        return repository.findAll();
    }

    public List<Book> getBookByCategory(Category category){
        List<Book> allBooks = repository.findAll();
        List<Book> booksFromACategory=new ArrayList<>();

        for (Book b: allBooks){
            if(b.getCategory().equals(category)){
                booksFromACategory.add(b);
            }
        }            
        return booksFromACategory;
    }

    public Book getBookById(long id){
        return repository.findById(id).orElseThrow();
    }
}
