package com.bookshelf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.model.Address;
import com.bookshelf.demo.services.AddressService;

@RestController
@RequestMapping("/api/address")
@CrossOrigin("http://localhost:3000")
public class AddressController {
    @Autowired
    public AddressService service;

    @PostMapping("/addAddress")
    public Address saveAddress(@RequestBody Address address){
        return service.saveAddress(address);
    }
}
