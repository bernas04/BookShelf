package com.bookshelf.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.model.Order;
import com.bookshelf.demo.services.OrderService;



public class OrderController {

    @Autowired
    public OrderService orderService;

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping("/Orders")
    public List<Order> getAllOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/Order")
    public Order getOrderId(@RequestParam(value = "id") Long id){
        return orderService.getOrderById(id);
    }

    


}
