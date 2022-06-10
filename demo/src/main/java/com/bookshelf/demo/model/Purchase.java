package com.bookshelf.demo.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    @Column(name="riderReview")
    private int riderReview;

    @Column(name = "orderStatus")
    private OrderStatus status;

    @Column(name = "deliverTs")
    private long deliverTs;

    @Column(name = "creationTs")
    private long creationTS;

    @Column(name="creation")
    private long creation;

    @Column(name="clientName")
    private String clientName;

    @Column(name="riderName")
    private String riderName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", nullable = false)
    @JsonBackReference
    private Client client;

    @Column(unique = true)
    @JsonIgnore
    private long genericServiceID;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable=false)
    private Address address;

    @ManyToMany
    @JoinTable(name = "purchase_books",joinColumns = @JoinColumn(name = "purchase_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;


    public Purchase(Client client, Address address, List<Book> books) {
        this.client = client;
        this.address = address;
        this.books = books;
        this.status = OrderStatus.REQUESTED;
    }


    public Purchase() {}

}
