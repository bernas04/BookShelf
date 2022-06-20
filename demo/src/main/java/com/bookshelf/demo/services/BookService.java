package com.bookshelf.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Category;
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

    public List<Book> getFantasyBooks(){
        return bookRepository.findByCategory(Category.Fantasy.toString());
    }

    public List<Book> getHorrorBooks(){
        return bookRepository.findByCategory(Category.Horror.toString());
    }

    public List<Book> getSciFiBooks(){
        return bookRepository.findByCategory(Category.Science_Fiction.toString());
    }

    public Optional<Book> getBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public List<Category> getAllCategories() {
        List<Category> allCategories = new ArrayList<>();
        for (Category c: Category.values())
            allCategories.add(c);
        
        return allCategories;
    }
}
