package com.bookshelf.demo.model;

import java.sql.Time;
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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title, book_image, category, description;
    private Double price;
    private Time return_time;

    @ManyToOne
    private Client user;

    @ManyToOne
    private Store store;
    public Book(){
        
    }
    public Book(String title, String book_image, String category, String description, Double price) {
        this.title = title;
        this.book_image = book_image;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Time getReturn_time() {
        return return_time;
    }

    public void setReturn_time(Time return_time) {
        this.return_time = return_time;
    }

    public Client getUser() {
        return user;
    }

    public void setUser(Client user) {
        this.user = user;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Book [book_image=" + book_image + ", category=" + category + ", description=" + description + ", id="
                + id + ", price=" + price + ", return_time=" + return_time + ", store=" + store + ", title=" + title
                + ", user=" + user + "]";
    }

    
}
