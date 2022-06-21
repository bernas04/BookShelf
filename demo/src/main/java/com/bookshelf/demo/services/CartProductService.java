package com.bookshelf.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.CartProduct;
import com.bookshelf.demo.repository.BookRepository;
import com.bookshelf.demo.repository.CartProductRepository;
import com.bookshelf.demo.repository.CartRepository;

@Service
public class CartProductService {
    @Autowired
    public CartProductRepository cartProductRepository;

    @Autowired
    public CartRepository cartRepository;

    @Autowired
    public BookRepository bookRepository;

    public CartProduct saveCart(CartProduct cartProduct) {
        return cartProductRepository.save(cartProduct);
    }

    public List<Book> getCartProducts(Long user_id) {
        List<Book> books = new ArrayList<>();
        for (CartProduct cartProduct : cartProductRepository.findAll()) {
            if (cartProduct.getCart().getClient().getId() == user_id) {
                books.add(cartProduct.getBook());
            }

        }
        return books;
    }

    public Double getTotalPrice(Long user_id) {
        Double total_price = 0.0;
        for (CartProduct cartProduct : cartProductRepository.findAll()) {
            if (cartProduct.getCart().getClient().getId() == user_id) {
                total_price = total_price + cartProduct.getBook().getPrice();
            }
        }
        return total_price;

    }

    public String removeProduct(Long book_id) {
        for (CartProduct cartProduct2: cartProductRepository.findAll()){
            if (cartProduct2.getBook().getId() == book_id){
                cartProductRepository.delete(cartProduct2);
            }
        }
        return "Deleted!";
    }

}
