package com.bookshelf.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartTest {
    
    private static List<Cart> cartList= new ArrayList<>();
    
    static Address a1 = new Address("Rua da Pega", "Aveiro", "Portugal", "3870-067");
    static Address a2 = new Address("Rua de Sao Martinho", "Viseu", "Portugal", "3000-988");
    static Address a3 = new Address("Rua de Sacramento", "Braga", "Portugal", "3678-876");
    static Client client1 = new Client("Carlos", "admin","2002, 03, 12", "carlinhos", a1);
    static Client client2 = new Client("Joao", "joaozinho","1999, 02, 19", "joao", a2);
    static Client client3 = new Client("Maria", "maria","2004, 06, 01", "maria", a3);
    static Cart cart1 = new Cart(client1);
    static Cart cart2 = new Cart(client2);
    static Cart cart3 = new Cart(client3);


    @BeforeAll
    public static void setUp(){
        cartList.add(cart1);
        cartList.add(cart2);
        cartList.add(cart3);
    }

    @Test
    @DisplayName("Test data and formats")
    public void testDataAndFormats(){
        assertEquals(cartList.get(1).getId(), cart2.getId());
        assertEquals(cartList.get(2).getId(), cart3.getId());
        
        assertEquals(cartList.get(1).getClient(), cart2.getClient());
        assertEquals(cartList.get(2).getClient(), cart3.getClient());
    }

    @Test
    @DisplayName("Test list manipulation")
    public void testListManipulation(){
        assertEquals(cartList.size(), 3);
        cartList.remove(0);
        assertEquals(cartList.size(), 2);
        cartList.contains(cart2);
        cartList.clear();
        assertEquals(cartList.size(), 0);
    }

}