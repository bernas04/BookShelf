package com.bookshelf.demo.model;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title; 
    
    @Column(name="category")
    private Category category;

    @Column(name = "price")
    private Double price;

    @ManyToMany(mappedBy = "books")
    private Set<Purchase> purchase;

    public Book(String title, Category category, Double price) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.purchase=new HashSet<>();
    }

    public Book() {
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Purchase> getPurchase() {
        return this.purchase;
    }

    public void setPurchase(Set<Purchase> purchase) {
        this.purchase = purchase;
    }



    
}
