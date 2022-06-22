package com.bookshelf.demo;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import com.bookshelf.demo.model.Address;
import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.repository.BookRepository;
import com.bookshelf.demo.services.AddressService;
import com.bookshelf.demo.services.BookService;
import com.bookshelf.demo.services.ClientService;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class TqsApplication {
	
	// @Autowired
	// private BookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(TqsApplication.class, args);
	}
	
	
	// @Transactional
	// @Bean
	// public CommandLineRunner demo(BookService bookService, ClientService clientService, AddressService addressService){
	// 	return(args) -> {
	// 		if (bookService.getBooks().size() == 0){
	// 			bookService.saveBook(new Book("Cruel Crown","Victoria Aveyard" , 12.0));
	// 			bookService.saveBook(new Book("Kings Cage","Victoria Aveyard", 15.0));
	// 			bookService.saveBook(new Book("Glass Sword", "Victoria Aveyard", 13.0));
	// 			bookService.saveBook(new Book("Red Queen", "Victoria Aveyard", 13.0));
	// 			bookService.saveBook(new Book("War Storm", "Victoria Aveyard", 13.0));
	// 			bookService.saveBook(new Book("Broken Throne", "Victoria Aveyard", 12.0));
	// 			bookService.saveBook(new Book("Red White and Royal Blue","Casey McQuiston",  14.0));
	// 			bookService.saveBook(new Book("The Hatting Game", "Sally Thorne",  11.0));
	// 			// bookService.saveBook(new Book("The Love Hypothesis", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
	// 			// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
	// 			// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
	// 			// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
	// 			// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
	// 			// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
	// 			// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
	// 		}
	// 		if (clientService.getClients().size()==0){
	// 			Address tmp = new Address("Rua da Pega", "Aveiro", "PT", "3800");
	// 			addressService.saveAddress(tmp);
	// 			clientService.saveClient(new Client("Maria", "admin", "17-05-1996", "mary", tmp));
	// 		}


	// 	// };
	// }


}
