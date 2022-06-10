package com.bookshelf.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="client")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "name")
    private String name;

    @Column(name="password")
    @JsonIgnore
    private String password;

    @Column(name = "email", unique = true)
    private String email;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Address> address;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Purchase> purchases;




    public Client(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
        this.purchases = new ArrayList<>();
        this.address = new HashSet<>();
    }

    public Client(){}


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Address> getAddress() {
        return this.address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public List<Purchase> getAllPurchases() {
        return this.purchases;
    }

    public void setAllPurchases(List<Purchase> allPurchases) {
        this.purchases = allPurchases;
    }


    
}
