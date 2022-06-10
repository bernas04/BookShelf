package com.bookshelf.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookshelf.demo.model.Address;
import com.bookshelf.demo.model.Client;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    List<Address> findAllByClient(Client person);
}
