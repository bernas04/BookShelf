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

import com.bookshelf.demo.model.Address;
import com.bookshelf.demo.model.Book;
import com.bookshelf.demo.model.Client;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepositoryTest {

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
    private ClientRepository clientRepository;

    @Test
    public void getClientInfo(){
        Address a1 = new Address("Rua do Louro", "Leiria", "Portugal", "4009-409");
        Client client = new Client("Carlos", "admin","2002, 03, 12", "carlinhos", a1);
        entityManager.persistAndFlush(client);

        List<Client> allClients = clientRepository.findAll();
        assertThat(allClients).isNotEmpty().hasSize(1).extracting(Client::getName).containsExactly(client.getName());
    }

    @Test
    public void findByInvalidId(){
        Address a1 = new Address("Rua do Louro", "Leiria", "Portugal", "4009-409");
        Client client = new Client("Carlos", "admin","2002, 03, 12", "carlinhos", a1);
        entityManager.persistAndFlush(client);
        Optional<Client> clientDB = clientRepository.findById(client.getId()*200L);
        assertThat(clientDB).isEmpty().isNotPresent();
    }

    @Test
    public void getEmptyList(){
        List<Client> allClients = clientRepository.findAll();
        assertThat(allClients).hasSize(0).isEmpty();
    }
    
}
