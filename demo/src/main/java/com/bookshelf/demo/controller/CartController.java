package com.bookshelf.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.model.Book;
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
    
    @GetMapping("/Carts")
    public List<Cart> getCarts(){
        return cartService.getCarts();
    }
    @PostMapping("/addCart/{client_id}/{product_id}")
    public CartProduct addCart(@PathVariable(value = "client_id") Long client_id, @PathVariable(value = "product_id") Long product_id) throws IOException, InterruptedException{
        return cartService.addCart(client_id, product_id);

    }

    @GetMapping("products/{client_id}")
    public List<CartProduct> getProducts(@PathVariable(value = "client_id") Long client_id){
        List<Book> cart_books= new ArrayList<>();
        // for(CartProduct cartProduct: cartService.getProducts(client_id)){
        //     cart_books.add(cartProduct.getBook());
        // }

        return cartService.getProducts(client_id);
    }
    
}
