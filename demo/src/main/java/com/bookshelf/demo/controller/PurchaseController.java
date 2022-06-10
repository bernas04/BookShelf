package com.bookshelf.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.DataTransferObject.PurchaseGeneric;
import com.bookshelf.demo.model.Purchase;
import com.bookshelf.demo.services.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    
    @Autowired
    private PurchaseService service;

    @PostMapping("/register")
    public Purchase createPurchase(@RequestBody PurchaseGeneric purchase, @PathVariable int clientId){
        return service.newPurchase(purchase, clientId);
    }

    @GetMapping("/all")
    public List<Purchase> allPurchases(int clientID){
        return service.clientsOrders(clientID);
    }
}
