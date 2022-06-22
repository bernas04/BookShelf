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

import com.bookshelf.demo.model.Address;
import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Cart;
import com.bookshelf.demo.model.CartProduct;
import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.repository.BookRepository;
import com.bookshelf.demo.repository.CartProductRepository;
import com.bookshelf.demo.repository.CartRepository;
import com.bookshelf.demo.services.BookService;
import com.bookshelf.demo.services.CartProductService;
import com.bookshelf.demo.services.CartService;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
    
    @InjectMocks
    private CartService cartService;

    @Mock
    private CartRepository cartRepository;


    @Test
    public void whenThereIsNoCarts(){
        List<Cart> emptyList = new ArrayList<>();
        Mockito.when(cartRepository.findAll()).thenReturn(emptyList);
        List<Cart> carts = cartService.getCarts();
        Mockito.verify(cartRepository, VerificationModeFactory.times(1)).findAll();
        assertThat(carts).isNotNull().isEmpty();
    }

    @Test
    public void whenSaveCartReturnIt(){
        Cart cart = new Cart();
        Mockito.when(cartRepository.save(cart)).thenReturn(cart);

        Cart cartDB = cartService.saveCart(cart);

        Mockito.verify(cartRepository, VerificationModeFactory.times(1)).save(cart);

        assertThat(cart).isEqualTo(cartDB);
    }

    @Test
    public void whenGetVariousCarts(){
        Address a1 = new Address("Rua da Pega", "Aveiro", "Portugal", "3870-067");
        Address a2 = new Address("Rua de Sao Martinho", "Viseu", "Portugal", "3000-988");
        Address a3 = new Address("Rua de Sacramento", "Braga", "Portugal", "3678-876");
        Client client1 = new Client("Carlos", "admin","2002, 03, 12", "carlinhos", a1);
        Client client2 = new Client("Joao", "joaozinho","1999, 02, 19", "joao", a2);
        Client client3 = new Client("Maria", "maria","2004, 06, 01", "maria", a3);
        Cart cart1 = new Cart(client1);
        Cart cart2 = new Cart(client2);
        Cart cart3 = new Cart(client3);
        

        List<Cart> allCarts = new ArrayList<>();
        allCarts.add(cart1);
        allCarts.add(cart2);
        allCarts.add(cart3);

        Mockito.when(cartRepository.findAll()).thenReturn(allCarts);

        List<Cart> cartsDB = cartService.getCarts();

        Mockito.verify(cartRepository, VerificationModeFactory.times(1)).findAll();

        assertThat(cartsDB).hasSize(allCarts.size()).extracting(Cart::getClient)
                                                    .extracting(Client::getId)
                                                    .containsExactly(cart1.getClient().getId(), cart2.getClient().getId(), cart3.getClient().getId());
    }

}

