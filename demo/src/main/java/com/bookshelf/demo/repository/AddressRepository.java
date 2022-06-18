package com.bookshelf.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bookshelf.demo.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    
}
