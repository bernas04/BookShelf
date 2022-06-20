package com.bookshelf.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.services.CartProductService;

@RestController
@RequestMapping("/api/cartProducts")
@CrossOrigin("http://localhost:3000")
public class CartProductController {

    @Autowired
    private CartProductService cartProductService;

    @GetMapping("books/{cart_id}")
    public List<Book> getProducts(@PathVariable(value = "cart_id") Long cart_id){
        List<Book> cart_books= new ArrayList<>();
        // for(CartProduct cartProduct: cartService.getProducts(client_id)){
        //     cart_books.add(cartProduct.getBook());
        // }

        return cartProductService.getCartProducts(cart_id);
    }
    
}
