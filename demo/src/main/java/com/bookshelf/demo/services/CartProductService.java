package com.bookshelf.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshelf.demo.model.CartProduct;
import com.bookshelf.demo.repository.CartProductRepository;

@Service
public class CartProductService {
    @Autowired
    public CartProductRepository cartRepository;

    public CartProduct saveCart(CartProduct cartProduct){
        return cartRepository.save(cartProduct);
    }

    
}
