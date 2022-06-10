package com.bookshelf.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.DataTransferObject.AddressGeneric;
import com.bookshelf.demo.model.Address;
import com.bookshelf.demo.services.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressService service;

    @GetMapping("/getAll")
    public List<Address> getAllByUser(@RequestBody String email){
        
        List<Address> listAddress = service.getAddressByUser(email);
        return listAddress;

    }

    @PostMapping("/addAddress/{pid}")
    public Address addAddress(@RequestBody AddressGeneric address, @PathVariable(value = "pid") int pid){
        Address tmp = service.createAddress(address, pid);
        return tmp;
    }

    @DeleteMapping("/drop/{pid}")
    public String deleteAddress(@PathVariable(value = "pid") int pid){
        String tmp = service.deleteAddress(pid);
        return tmp;
    }
}
