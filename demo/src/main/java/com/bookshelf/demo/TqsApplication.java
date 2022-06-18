package com.bookshelf.demo;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.repository.BookRepository;
import com.bookshelf.demo.services.BookService;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class TqsApplication {
	
	@Autowired
	private BookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(TqsApplication.class, args);
	}
	
	
	@Transactional
	@Bean
	public CommandLineRunner demo(BookService bookService){
		return(args) -> {
			if (bookService.getBooks().size() == 0){
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The 50 shades of Gray", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "Sex", 15.0));
				bookService.saveBook(new Book("PUTAS", "https://www.imdb.com/title/tt3040964/", "Jonh August","Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				bookService.saveBook(new Book("The Book of the jungle", "Jonh August","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				
			}


		};
	}


}
