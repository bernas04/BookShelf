package com.bookshelf.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartProductTest {
    
    private static List<CartProduct> cartProductList= new ArrayList<>();
    
        static Cart cart1 = new Cart();
        static Cart cart2 = new Cart();
        static Cart cart3 = new Cart();
        static Book book1 = new Book("Red Queen", "John Stewart", "image", "Romance", "A Love Story", 12.0);
        static Book book2 = new Book("Blue Queen", "Joao Eduardo", "image", "Horror", "A killer goes after teenager", 14.0);
        static Book book3 = new Book("Green Queen", "Mario Almeida", "image", "Romance", "A love Story", 20.0);
        static CartProduct cartProduct1 = new CartProduct(cart1, book1, 9);
        static CartProduct cartProduct2 = new CartProduct(cart2, book2, 6);
        static CartProduct cartProduct3 = new CartProduct(cart3, book3, 5);


    @BeforeAll
    public static void setUp(){
        cartProductList.add(cartProduct1);
        cartProductList.add(cartProduct2);
        cartProductList.add(cartProduct3);
    }

    @Test
    @DisplayName("Test data and formats")
    public void testDataAndFormats(){
        assertEquals(cartProductList.get(1).getId(), cartProduct2.getId());
        assertEquals(cartProductList.get(2).getId(), cartProduct3.getId());
        
        assertEquals(cartProductList.get(1).getBook(), cartProduct2.getBook());
        assertEquals(cartProductList.get(2).getBook(), cartProduct3.getBook());

        assertEquals(cartProductList.get(1).getQuantity(), cartProduct2.getQuantity());
        assertEquals(cartProductList.get(2).getQuantity(), cartProduct3.getQuantity());

        assertEquals(cartProductList.get(1).getCart(), cartProduct2.getCart());
        assertEquals(cartProductList.get(2).getCart(), cartProduct3.getCart());
    }

    @Test
    @DisplayName("Test list manipulation")
    public void testListManipulation(){
        assertEquals(cartProductList.size(), 3);
        cartProductList.remove(0);
        assertEquals(cartProductList.size(), 2);
        cartProductList.contains(cartProduct2);
        cartProductList.clear();
        assertEquals(cartProductList.size(), 0);
    }

}