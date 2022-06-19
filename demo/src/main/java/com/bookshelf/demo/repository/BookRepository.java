package com.bookshelf.demo.repository;

import java.util.List;
import java.util.Optional;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Optional<Book> findByTitle(String title);
    List<Book> findByCategory(String c);
}
