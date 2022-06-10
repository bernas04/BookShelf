package com.bookshelf.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name="road")
    private String road;
    
    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="zipcode")
    private String zipcode;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable=false)
    private Client client;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<Purchase> purchases;

    public Address(String road, String city, String country, String zipcode, Client client) {
        this.road = road;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
        this.client=client;
        this.purchases=new ArrayList<>();
    }


    public Address() {
    }


    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    public Client getUser() {
        return this.client;
    }

    public void setUser(Client user) {
        this.client = user;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", country=" + country + ", id=" + id + ", road=" + road
                + ", user=" + client + ", zipcode=" + zipcode + "]";
    }

    
}
