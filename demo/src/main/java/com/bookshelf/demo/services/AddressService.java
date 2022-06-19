package com.bookshelf.demo.services;

import com.bookshelf.demo.repository.AddressRepository;

import java.util.List;

import com.bookshelf.demo.model.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    
    @Autowired
    public AddressRepository addressRepository;

    public Address saveAddress(Address s){
        return addressRepository.save(s);
    }

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Address getAddressId(Long id){
        return addressRepository.getReferenceById(id);
    }

    public void deleteById(Long id){
        addressRepository.deleteById(id);

    }
}
