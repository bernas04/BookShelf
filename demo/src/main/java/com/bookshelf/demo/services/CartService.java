package com.bookshelf.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshelf.demo.model.Cart;
import com.bookshelf.demo.model.CartProduct;
import com.bookshelf.demo.repository.CartRepository;

import com.bookshelf.demo.model.Cart;
import com.bookshelf.demo.model.CartProduct;
import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.repository.BookRepository;
import com.bookshelf.demo.repository.CartProductRepository;
import com.bookshelf.demo.repository.CartRepository;
import com.bookshelf.demo.repository.ClientRepository;
import com.bookshelf.demo.services.CartService;

@Service
public class CartService {



    @Autowired
    private ClientRepository clientRepository;


    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    public CartRepository cartRepository;

    @Autowired
    public BookRepository bookRepository;

    public Cart saveCart(Cart cart){
        return cartRepository.save(cart);
    }

    public CartProduct addCart(Long client_id, Long book_id){
        Optional<Client> client = clientRepository.findById(client_id);
        Cart cart = cartRepository.findByClient(client);
        for(CartProduct cartProduct: cart.getCartProducts()){
            if(cartProduct.getBook().getId() == book_id){
                cartProduct.setQuantity(cartProduct.getQuantity() + 1);
                return cartProductRepository.save(cartProduct);
            }
        }
        return cartProductRepository.save(new CartProduct(cart, bookRepository.findById(book_id).get(), 1));
        
    }
    
}
