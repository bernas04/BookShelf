package com.bookshelf.demo.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientTest {
    
    static Address a1 = new Address("Rua da Pega", "Aveiro", "Portugal", "3870-067");

    private static Client client = new Client("Carlos", "admin","2002, 04, 25", "carlinhos", a1);
    private static List<Order> listOrders = new ArrayList<>();
    
    @BeforeAll
    public static void setUp(){
        Order c = new Order();
        listOrders.add(c);
        client.setOrders(listOrders);
    }

    @Test
    @DisplayName("Test Client")
    public void testClient(){
        Address a2 = new Address("Rua de Sao Martinho", "Viseu", "Portugal", "3004-334");
        client.setUsername("vasquinho");
        client.setAddress(a2);

        assertEquals(client.getUsername(), "vasquinho");
        assertEquals(client.getAddress(), a2);

        listOrders.add(new Order());
        assertEquals(listOrders.size(), 2);
        listOrders.clear();
        assertEquals(listOrders.size(), 0);
    }

}
