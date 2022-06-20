package com.bookshelf.demo.repository;


import com.bookshelf.demo.model.Cart;
import com.bookshelf.demo.model.Client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
    Optional<Cart> findByClient(Optional<Client> client);
}
