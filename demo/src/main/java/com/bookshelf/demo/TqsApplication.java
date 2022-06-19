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
				bookService.saveBook(new Book("Cruel Crown","Victoria Aveyard" ,"https://www.imdb.com/title/tt3040964/", "Fiction", "Queen Coriane, first wife of King Tiberias, keeps a secret diary—how else can she ensure that no one at the palace will use her thoughts against her? Coriane recounts her heady courtship with the crown prince, the birth of a new prince, Cal, and the potentially deadly challenges that lie ahead for her in royal life.", 12.0));
				bookService.saveBook(new Book("Kings Cage","Victoria Aveyard", "https://www.messenger.com/messenger_media/?thread_id=100003813978172&attachment_id=390542636381394&message_id=mid.%24cAAAAACI1DdKHqi1JsGBeOf_1pIeB", "Fiction", "Mare Barrow is a prisoner, powerless without her lightning, tormented by her lethal mistakes. She lives at the mercy of a boy she once loved, a boy made of lies and betrayal. Now a king, Maven Calore continues weaving his dead mother's web in an attempt to maintain control over his country—and his prisoner.", 15.0));
				bookService.saveBook(new Book("Glass Sword", "Victoria Aveyard","https://www.imdb.com/title/tt3040964/", "Fiction", "This series tells the story of Mare Barrow. She lives in a dystopian future where society is split into red bloods and silver bloods, the silvers being the rich or royalty. The silvers have god-like powers which allow them to control the common-folk reds", 13.0));
				bookService.saveBook(new Book("Red Queen", "Victoria Aveyard", "https://www.imdb.com/title/tt3040964/", "Fiction", "Red Queen tells the story of Mare Barrow, a 17 year old girl who lives in a world where status depends on the colour of your blood. Those with red blood are commoners yet those with silver are royals who possess special powers.", 13.0));
				bookService.saveBook(new Book("War Storm", "Victoria Aveyard","https://www.imdb.com/title/tt3040964/", "Fiction", "starting with the crown on Maven's head. But no battle is won alone, and before the Reds may rise as one, Mare must side with the boy who broke her heart in order to defeat the boy who almost broke her. Cal's powerful Silver allies, alongside Mare and the Scarlet Guard, prove a formidable force.", 13.0));
				bookService.saveBook(new Book("Broken Throne", "Victoria Aveyard","https://www.imdb.com/title/tt3040964/", "Science Fiction", "BROKEN THRONE: A RED QUEEN COLLECTION is just that, a collection of short story/novellas, maps, journal entries, and fictional research into the history of the Red Queen world.", 12.0));
				bookService.saveBook(new Book("Red White and Royal Blue","Casey McQuiston", "https://www.imdb.com/title/tt3040964/", "Romance", "Red, White & Royal Blue is a 2019 LGBT romance novel by Casey McQuiston. The novel centres around the character of Alex Claremont-Diaz, the First Son of the United States, and his romantic relationship with Prince Henry, a British prince.g", 14.0));
				bookService.saveBook(new Book("The Hatting Game", "Sally Thorne", "https://www.imdb.com/title/tt3040964/", "Romance", "The story of The Hating Game by Sally Thorne revolves around Lucy Hutton and Joshua Templeman, two executive assistants forced together when rival publishing companies merge, making their respective bosses co-CEOs. They spend their days antagonizing each other and verbally sparring.", 11.0));
				// bookService.saveBook(new Book("The Love Hypothesis", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				// bookService.saveBook(new Book("The Book of the jungle", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy died of alchool poisoning", 12.0));
				
			}


		};
	}


}
