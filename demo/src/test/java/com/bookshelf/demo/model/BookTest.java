package com.bookshelf.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {
    
    private static List<Book> bookList= new ArrayList<>();
    
    static Book book1 = new Book("Red Queen", "John Stewart", "image", "Romance", "A Love Story", 12.0);
    static Book book2 = new Book("Blue Queen", "Joao Eduardo", "image", "Horror", "A killer goes after teenager", 14.0);
    static Book book3 = new Book("Green Queen", "Mario Almeida", "image", "Romance", "A love Story", 20.0);


    @BeforeAll
    public static void setUp(){
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
    }

    @Test
    @DisplayName("Test data and formats")
    public void testDataAndFormats(){
        assertEquals(bookList.get(1).getId(), book2.getId());
        assertEquals(bookList.get(2).getId(), book3.getId());
        
        assertEquals(bookList.get(1).getTitle(), book2.getTitle());
        assertEquals(bookList.get(2).getTitle(), book3.getTitle());

        assertEquals(bookList.get(1).getCategory(), book2.getCategory());
        assertEquals(bookList.get(2).getCategory(), book3.getCategory());

        assertEquals(bookList.get(1).getPrice(), book2.getPrice());
        assertEquals(bookList.get(2).getPrice(), book3.getPrice());
    }

    @Test
    @DisplayName("Test list manipulation")
    public void testListManipulation(){
        assertEquals(bookList.size(), 3);
        bookList.remove(0);
        assertEquals(bookList.size(), 2);
        bookList.contains(book2);
        bookList.clear();
        assertEquals(bookList.size(), 0);
    }

}
