package com.bookshelf.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshelf.demo.DataTransferObject.AddressGeneric;
import com.bookshelf.demo.model.Address;
import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.repository.AddressRepository;
import com.bookshelf.demo.repository.ClientRepository;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Address createAddress(AddressGeneric addressGeneric, long clientId){
        Client c = clientRepository.findById(clientId).orElseThrow();
        Address a = new Address(addressGeneric.getRoad(), addressGeneric.getCity(), addressGeneric.getCountry(), addressGeneric.getZipcode(), c);

        return addressRepository.save(a);
    }

    public String deleteAddress(long addressID){
        Address a = addressRepository.findById(addressID).orElseThrow();
        if (a!=null)
            addressRepository.deleteById(addressID);
            return "Address deleted";
    }

    public List<Address> getAddressByUser(String email){
        Client c = clientRepository.findByEmail(email).orElseThrow();
        return addressRepository.findAllByClient(c);
    }
}
