package com.bookshelf.demo.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    @CreationTimestamp
    private Date date;

    @ManyToOne
    private User user;

    @OneToMany
    private Book book;




}
