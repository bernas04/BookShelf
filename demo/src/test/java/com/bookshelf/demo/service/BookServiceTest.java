package com.bookshelf.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Store;
import com.bookshelf.demo.repository.BookRepository;
import com.bookshelf.demo.services.BookService;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;


    @Test
    public void whenThereIsNoBooks(){
        List<Book> emptyList = new ArrayList<>();
        Mockito.when(bookRepository.findAll()).thenReturn(emptyList);
        List<Book> returned = bookService.getBooks();
        Mockito.verify(bookRepository, VerificationModeFactory.times(1)).findAll();
        assertThat(returned).isNotNull().isEmpty();
    }

    // @Test
    // public void whenSaveBookReturnIt(){
    //     Book book = new Book("Red Queen", "John Stewart", "image", "category", "A Love Story", 12.0);
    //     Mockito.when(bookRepository.save(book)).thenReturn(book);

    //     Book bookDB = bookService.saveBook(book);

    //     Mockito.verify(bookRepository, VerificationModeFactory.times(1)).save(book);

    //     assertThat(book).isEqualTo(bookDB);
    // }

    // @Test
    // public void whenGetVariousBooks(){
    //     Book book1 = new Book("Red Queen", "John Stewart", "image", "Romance", "A Love Story", 12.0);
    //     Book book2 = new Book("Blue Queen", "Joao Eduardo", "image", "Horror", "A killer goes after teenager", 14.0);
    //     Book book3 = new Book("Green Queen", "Mario Almeida", "image", "Romance", "A love Story", 20.0);

    //     List<Book> allBooks = new ArrayList<>();
    //     allBooks.add(book1);
    //     allBooks.add(book2);
    //     allBooks.add(book3);

    //     Mockito.when(bookRepository.findAll()).thenReturn(allBooks);

    //     List<Book> bookDB = bookService.getBooks();

    //     Mockito.verify(bookRepository, VerificationModeFactory.times(1)).findAll();

    //     assertThat(bookDB).hasSize(allBooks.size()).extracting(Book::getStore)
    //                                                 .extracting(Store::getName)
    //                                                 .containsExactly(book1.getStore().getName(), book2.getStore().getName(), book3.getStore().getName());
    // }

}
