package com.bookshelf.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    
    private String password;

    private String birthDate;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    private String token;

    @Column(unique = true)
    private String username;

    @OneToOne
    private Cart cart;
    
    public Client(){
        
    }

    public Client(String name, String password, String birthDate, String username) {
        this.name = name;
        this.password = password;
        this.birthDate = birthDate;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId(){
        return this.id;
    }

    public Address getAddress(){
        return this.address;
    }

    public List<Order> getOrders(){
        return this.orders;
    }

    public void setToken(String token){
        this.token=token;
    }

    public String getToken(){
        return this.token;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", password='" + getPassword() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", address='" + getAddress() + "'" +
            ", orders='" + getOrders() + "'" +
            ", token='" + getToken() + "'" +
            ", username='" + getUsername() + "'" +
            "}";
    }
                                                                
}
