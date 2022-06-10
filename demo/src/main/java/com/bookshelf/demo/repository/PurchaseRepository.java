package com.bookshelf.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
    List<Purchase> findAllByClient(Client c);
}
