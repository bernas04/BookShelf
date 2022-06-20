package com.bookshelf.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String road, city, country, zipcode;

    @OneToOne
    private Store store;

    @OneToOne(cascade = CascadeType.ALL)
    private Client user;

    public Address(){
        
    }
    public Address(String road, String city, String country, String zipcode) {
        this.road = road;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }

    

    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Client getUser() {
        return user;
    }

    public void setUser(Client user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", country=" + country + ", id=" + id + ", road=" + road + ", store=" + store
                + ", user=" + user + ", zipcode=" + zipcode + "]";
    }

    
}
