package com.bookshelf.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshelf.demo.model.Cart;
import com.bookshelf.demo.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    public CartRepository cartRepository;

    public Cart saveCart(Cart cart){
        return cartRepository.save(cart);
    }

    
}
