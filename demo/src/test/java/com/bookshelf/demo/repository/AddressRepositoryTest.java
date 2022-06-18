package com.bookshelf.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.bookshelf.demo.model.Address;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AddressRepositoryTest{
    // @Container
    // static PostgreSQLContainer container = new PostgreSQLContainer("postgres:11.12").withUsername("postgres")
    //                                                                          .withPassword("root")
    //                                                                          .withDatabaseName("bookshelf");

    // @DynamicPropertySource
    // public static void properties(DynamicPropertyRegistry registry) {
    //     registry.add("spring.datasource.url", container::getJdbcUrl);
    //     registry.add("spring.datasource.password", container::getPassword);
    //     registry.add("spring.datasource.username", container::getUsername);
    // }

    @Autowired
    private AddressRepository repository;

    @Autowired
    private TestEntityManager manager;

    @Test
    public void createTwoAdrressesSaveThemAndGetALL(){
        Address a1 = new Address("Rua de Sao Martinho", "Viseu", "Portugal", "4201");
        Address a2 = new Address("Rua dos Gatos", "Lisboa", "Portugal", "5531");

        manager.persistAndFlush(a1);
        manager.persistAndFlush(a2);

        List<Address> allAddress = repository.findAll();

        assertThat(allAddress).isNotNull().hasSize(2).extracting(Address::getId).contains(a1.getId(), a2.getId());
        assertThat(allAddress).isNotNull().extracting(Address::getRoad).containsExactly(a1.getRoad(), a2.getRoad()).hasExactlyElementsOfTypes(String.class, String.class);

    }

    @Test
    public void getEmptyListAndCheckIsEmpty(){
        List<Address> allAddress = repository.findAll();

        assertThat(allAddress).isNotNull().isEmpty();
    }

    @Test
    public void findById(){
        Address a = new Address("Rua da Pega", "Aveiro", "Portugal", "3800");
        manager.persistAndFlush(a);
        
        Optional<Address> fromRep = repository.findById(a.getId());

        assertThat(fromRep).contains(a).hasValue(a);
    }

    @Test
    public void findByInvalidId(){
        Optional<Address> fromRep=repository.findById(1000000000000L);
        assertThat(fromRep).isNotNull().isEmpty().isNotPresent();
    }
}