package com.bookshelf.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.repository.BookRepository;
import com.bookshelf.demo.repository.CartProductRepository;
import com.bookshelf.demo.services.CartProductService;

@RestController
@RequestMapping("/api/cartProducts")
@CrossOrigin("http://localhost:3000")
public class CartProductController {

    @Autowired
    private CartProductService cartProductService;

    

    @GetMapping("books/{user_id}")
    public List<Book> getProducts(@PathVariable(value = "user_id") Long user_id){
        return cartProductService.getCartProducts(user_id);
    }

    @GetMapping("totalrice/{user_id}")
    public Double getTotalPrice(@PathVariable(value = "user_id") Long user_id){
        return cartProductService.getTotalPrice(user_id);
    }

    @PostMapping("removeBook/{book_id}")
    public String removeBook(@PathVariable(value = "book_id") Long book_id){
        cartProductService.removeProduct(book_id);
        return "Deleted!";
    }
    
}
