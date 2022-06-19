package com.bookshelf.demo.services;

import java.util.List;

import com.bookshelf.demo.model.Order;
import com.bookshelf.demo.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id){
        return orderRepository.getReferenceById(id);
    }

    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);
    }
}
