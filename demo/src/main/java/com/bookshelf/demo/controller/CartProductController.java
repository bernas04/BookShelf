package com.bookshelf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.services.CartProductService;

@RestController
@RequestMapping("/api/cartProducts")
@CrossOrigin("http://localhost:3000")
public class CartProductController {

    @Autowired
    private CartProductService cartProductService;

    
    
}
