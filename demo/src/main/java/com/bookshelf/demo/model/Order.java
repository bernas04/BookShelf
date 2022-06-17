package com.bookshelf.demo.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="orders") 
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    @CreationTimestamp
    private Date date;

    @ManyToOne
    private Client user;  

    @OneToMany
    private List<Book> books;

    @OneToOne
    private Address address;


    @Enumerated
    private OrderStatus status;

    private int riderReview;

    private String rider;

    public Order(Client user, Address address, List<Book> books) {
        this.user = user;
        this.address = address;
        this.books = books;
        this.status = OrderStatus.REQUESTED;
    }

    public Order(){}


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getUser() {
        return this.user;
    }

    public void setUser(Client user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getRiderReview() {
        return this.riderReview;
    }

    public void setRiderReview(int riderReview) {
        this.riderReview = riderReview;
    }

    public String getRider() {
        return this.rider;
    }

    public void setRider(String rider) {
        this.rider = rider;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", date='" + getDate() + "'" +
            ", user='" + getUser() + "'" +
            ", books='" + getBooks() + "'" +
            ", address='" + getAddress() + "'" +
            ", status='" + getStatus() + "'" +
            ", riderReview='" + getRiderReview() + "'" +
            ", rider='" + getRider() + "'" +
            "}";
    }

}
