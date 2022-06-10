package com.bookshelf.demo;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Category;
import com.bookshelf.demo.repository.BookRepository;
import com.bookshelf.demo.services.BookService;

@SpringBootApplication
public class TqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TqsApplication.class, args);
	}

	@Transactional
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository){
		return(args) -> {

			if (bookRepository.findAll().size()==0){
				Book b1 = new Book("Anna Karenina", Category.Fantasy, 19.85);
				Book b2 = new Book("Madame Bovary", Category.Science_Fiction, 16.67);
				Book b3 = new Book("War and Peace", Category.Horror, 21.89);
				Book b4 = new Book("The Great Gatsby", Category.Romance, 15.87);
				bookRepository.saveAndFlush(b1);
				bookRepository.saveAndFlush(b2);
				bookRepository.saveAndFlush(b3);
				bookRepository.saveAndFlush(b4);
			}
		};
	}

}
