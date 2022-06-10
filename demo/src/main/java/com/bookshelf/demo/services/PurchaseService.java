package com.bookshelf.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshelf.demo.DataTransferObject.AddressGeneric;
import com.bookshelf.demo.DataTransferObject.DeliveryGeneric;
import com.bookshelf.demo.DataTransferObject.PurchaseGeneric;
import com.bookshelf.demo.model.Address;
import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.model.Purchase;
import com.bookshelf.demo.repository.AddressRepository;
import com.bookshelf.demo.repository.BookRepository;
import com.bookshelf.demo.repository.ClientRepository;
import com.bookshelf.demo.repository.PurchaseRepository;

@Service
public class PurchaseService {
    
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BookRepository bookRepository;


    public Purchase newPurchase(PurchaseGeneric purchase, long clientId){
        
        Client c =clientRepository.findById(clientId).orElseThrow();
        Address a = addressRepository.findById(purchase.getAddressID()).orElseThrow();

        if (!a.getUser().getEmail().equals(c.getEmail())){
            new Exception("Incorrect address");
        }

        List<Long> booksID = purchase.getProductsID();
        List<Book> booksList = new ArrayList<>();

        for (Long id:booksID){
            Book tmp = bookRepository.findById(id).orElseThrow();
            booksList.add(tmp);
        }

        DeliveryGeneric dg = new DeliveryGeneric(c.getName(), new AddressGeneric(a.getRoad(), a.getCity(), a.getCountry(), a.getZipcode()), purchase.getDateStart());
    
        Purchase p = new Purchase(c, a, booksList);

        return purchaseRepository.save(p);
    }

    public List<Purchase> clientsOrders(long clientID){
        Client c = clientRepository.findById(clientID).orElseThrow();
        return purchaseRepository.findAllByClient(c);
    }   
}
