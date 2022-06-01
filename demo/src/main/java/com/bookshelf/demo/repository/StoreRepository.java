package com.bookshelf.demo.repository;

import com.bookshelf.demo.model.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends  JpaRepository<Store, Long>{
    
}
