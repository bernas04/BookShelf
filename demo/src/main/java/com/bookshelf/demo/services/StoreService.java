package com.bookshelf.demo.services;

import java.util.List;

import com.bookshelf.demo.model.Store;
import com.bookshelf.demo.repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    public StoreRepository StoreRepository;

    public Store saveStore(Store Store){
        return StoreRepository.save(Store);
    }

    public List<Store> getStores(){
        return StoreRepository.findAll();
    }

    public Store getStoreById(Long id){
        return StoreRepository.getReferenceById(id);
    }

    public void deleteStoreById(Long id){
        StoreRepository.deleteById(id);
    }
}
