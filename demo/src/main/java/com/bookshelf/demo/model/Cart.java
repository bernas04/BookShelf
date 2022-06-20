package com.bookshelf.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Client client;  
    
    @JoinColumn(name = "cart")
    @OneToMany(fetch =
    FetchType.LAZY)
    private List<CartProduct> cartProducts;

   



    public Cart(){

    }

    public Cart(Client client){
        this.client = client;
    }

    

    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Client getUser() {
        return client;
    }

    public void setUser(Client user) {
        this.client = user;
    }

    @Override
    public String toString() {
        return "Cart [client=" + client + ", id=" + id + "]";
    }

    

    
}
