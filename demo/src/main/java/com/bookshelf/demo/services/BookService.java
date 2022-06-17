package com.bookshelf.demo.services;

import java.util.List;
import java.util.Optional;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.getReferenceById(id);
    }

    public String deleteBookById(Long id){
        bookRepository.deleteById(id);
        return "Book deleted";
        
    }

    public Optional<Book> getBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }
}
