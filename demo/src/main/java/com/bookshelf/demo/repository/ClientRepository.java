package com.bookshelf.demo.repository;

import java.util.Optional;

import com.bookshelf.demo.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    Optional<Client> findByUsername(String username);
}
