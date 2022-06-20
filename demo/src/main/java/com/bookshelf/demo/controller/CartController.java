package com.bookshelf.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.model.Cart;
import com.bookshelf.demo.model.CartProduct;
import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.repository.CartProductRepository;
import com.bookshelf.demo.repository.CartRepository;
import com.bookshelf.demo.repository.ClientRepository;
import com.bookshelf.demo.services.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("http://localhost:3000")
public class CartController {

    @Autowired
    private CartService cartService;
    
    
    @PostMapping("/addCart/{client_id}/{product_id}")
    public CartProduct addCart(@PathVariable(value = "client_id") Long client_id, @PathVariable(value = "product_id") Long product_id){
        return cartService.addCart(client_id, product_id);

    }
    
}
