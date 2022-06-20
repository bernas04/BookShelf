package com.bookshelf.demo.repository;


import com.bookshelf.demo.model.CartProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long>{
    CartProduct findByBook(Long book_id);
}