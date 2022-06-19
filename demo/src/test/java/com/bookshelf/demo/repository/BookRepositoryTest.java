package com.bookshelf.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.bookshelf.demo.model.Book;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer("postgres:11.12").withUsername("postgres")
                                                                             .withPassword("root")
                                                                             .withDatabaseName("deliverme");



    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void getBookInfo(){
        Book book1 = new Book("The Book of the jungle", "Augusto", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy is raised by a bear in the jungle", 12.0);
        entityManager.persistAndFlush(book1);

        List<Book> allManagers = bookRepository.findAll();
        assertThat(allManagers).isNotEmpty().hasSize(1).extracting(Book::getTitle).containsExactly(book1.getTitle());
    }

    @Test
    public void findByInvalidId(){
        Book book1 = new Book("The Book of the jungle", "Augusto","https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy is raised by a bear in the jungle", 12.0);
        entityManager.persistAndFlush(book1);
        Optional<Book> repoManager = bookRepository.findById(book1.getId()*200L);
        assertThat(repoManager).isEmpty().isNotPresent();
    }

    @Test
    public void getEmptyList(){
        List<Book> allManagers = bookRepository.findAll();
        assertThat(allManagers).hasSize(0).isEmpty();
    }
    
}
