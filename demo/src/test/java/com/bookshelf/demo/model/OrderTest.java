package com.bookshelf.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    private List<Order> listOrders = new ArrayList<>();
    private List<Book> listBooks = new ArrayList<>();
    
    @BeforeEach
    public void setUp(){
        Address a1 = new Address("Rua da Pega", "Aveiro", "Portugal", "3870-067");
        Address a2 = new Address("Rua do Lodo", "Aveiro", "Portugal", "2222-222");

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        listBooks.add(book1);
        listBooks.add(book2);
        listBooks.add(book3);

        Order order = new Order();
        Client client = new Client("Carlos", "admin","2002, 04, 25", "carlinhos", a1);
        Store store = new Store();

        store.setName("Loja das meias");

        order.setDate(new Date(2021, 04,05,19,22));
        order.setClient(client);
        order.setStatus(OrderStatus.CANCELED);
        this.listOrders.add(order);
        this.listOrders.add(new Order(client, a2, listBooks));
    }

    @Test
    @DisplayName("Test cancel an order")
    public void testCancelOrder(){
        assertEquals(this.listOrders.get(0).getStatus(), OrderStatus.CANCELED);
    }

    @Test
    @DisplayName("Test in progress Orders")
    public void testInProgressOrders(){
        Client client2 = new Client("Joao", "admin","1960, 07, 18", "joaozinho", new Address());
        this.listOrders.get(0).setStatus(OrderStatus.IN_PROGRESS);
        this.listOrders.get(0).setClient(client2);
        assertEquals(this.listOrders.get(0).getStatus(), OrderStatus.IN_PROGRESS);
    }

}

