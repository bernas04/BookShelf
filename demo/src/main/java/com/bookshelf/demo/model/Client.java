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

    private String name, password;

    private Date birthDate;

    @OneToOne
    private Address address;

    @OneToMany
    private List<Book> books;



    @Column(unique = true)
    private String email;

    
    public Client(){

    }

    public Client(String name, String password, Date birthDate, String email) {
        this.name = name;
        this.password = password;
        this.birthDate = birthDate;
        this.email = email;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [address=" + address + ", birthDate=" + birthDate + ", book=" + books + ", email=" + email + ", id="
                + id + ", name=" + name + ", password=" + password + "]";
    }
    
    
                                                                    
}
