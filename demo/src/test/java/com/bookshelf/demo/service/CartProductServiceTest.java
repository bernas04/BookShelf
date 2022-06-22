package com.bookshelf.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Cart;
import com.bookshelf.demo.model.CartProduct;
import com.bookshelf.demo.repository.BookRepository;
import com.bookshelf.demo.repository.CartProductRepository;
import com.bookshelf.demo.services.BookService;
import com.bookshelf.demo.services.CartProductService;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CartProductServiceTest {
    
    @InjectMocks
    private CartProductService cartProductService;

    @Mock
    private CartProductRepository cartProductRepository;


    @Test
    public void whenThereIsNoCartProducts(){
        List<CartProduct> emptyList = new ArrayList<>();
        Mockito.when(cartProductRepository.findAll()).thenReturn(emptyList);
        List<CartProduct> cartProducts = cartProductService.getCartProducts();
        Mockito.verify(cartProductRepository, VerificationModeFactory.times(1)).findAll();
        assertThat(cartProducts).isNotNull().isEmpty();
    }

    @Test
    public void whenSaveCartProductReturIt(){
        CartProduct cartProduct = new CartProduct();
        Mockito.when(cartProductRepository.save(cartProduct)).thenReturn(cartProduct);

        CartProduct cartProductDB = cartProductService.saveCart(cartProduct);

        Mockito.verify(cartProductRepository, VerificationModeFactory.times(1)).save(cartProduct);

        assertThat(cartProduct).isEqualTo(cartProductDB);
    }

    @Test
    public void whenGetVariousCartProducts(){
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();
        Book book1 = new Book("Red Queen", "John Stewart", "image", "Romance", "A Love Story", 12.0);
        Book book2 = new Book("Blue Queen", "Joao Eduardo", "image", "Horror", "A killer goes after teenager", 14.0);
        Book book3 = new Book("Green Queen", "Mario Almeida", "image", "Romance", "A love Story", 20.0);
        CartProduct cartProduct1 = new CartProduct(cart1, book1, 9);
        CartProduct cartProduct2 = new CartProduct(cart2, book2, 6);
        CartProduct cartProduct3 = new CartProduct(cart3, book3, 5);

        List<CartProduct> allCartProducts = new ArrayList<>();
        allCartProducts.add(cartProduct1);
        allCartProducts.add(cartProduct2);
        allCartProducts.add(cartProduct3);

        Mockito.when(cartProductRepository.findAll()).thenReturn(allCartProducts);

        List<CartProduct> fromDB = cartProductService.getCartProducts();

        Mockito.verify(cartProductRepository, VerificationModeFactory.times(1)).findAll();

        assertThat(fromDB).hasSize(allCartProducts.size()).extracting(CartProduct::getCart)
                                                    .extracting(Cart::getId)
                                                    .containsExactly(cartProduct1.getCart().getId(), cartProduct2.getCart().getId(), cartProduct3.getCart().getId());
    }

}
