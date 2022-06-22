package com.bookshelf.demo.service;

import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookshelf.demo.model.Address;
import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.repository.ClientRepository;
import com.bookshelf.demo.services.ClientService;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    
    @InjectMocks
    private ClientService clientService;

    @Mock 
    private ClientRepository clientRepository;

    @Test
    public void whenThereIsNoClients(){
        List<Client> emptyList = new ArrayList<>();
        Mockito.when(clientRepository.findAll()).thenReturn(emptyList);
        List<Client> returned = clientService.getClients();
        Mockito.verify(clientRepository, VerificationModeFactory.times(1)).findAll();
        assertThat(returned).isNotNull().isEmpty();
    }

    // @Test
    // public void whenSaveClientReturnIt(){

    //     Address a1 = new Address("Rua da Pega", "Aveiro", "Portugal", "3870-067");
    //     Client client = new Client("Carlos", "admin","2002, 04, 25", "carlinhos", a1);
        
    //     Mockito.when(clientRepository.save(client)).thenReturn(client);
    //     Client clientDB = clientService.saveClient(client);

    //     Mockito.verify(clientRepository, VerificationModeFactory.times(1)).save(client);
    //     assertThat(client).isEqualTo(clientDB);
    // }

    @Test
    public void whenThereIsVariousClients(){
        Address a1 = new Address("Rua da Pega", "Aveiro", "Portugal", "3870-067");
        Address a2 = new Address("Rua de Sao Martinho", "Viseu", "Portugal", "3000-988");
        Address a3 = new Address("Rua de Sacramento", "Braga", "Portugal", "3678-876");
        Client client1 = new Client("Carlos", "admin","2002, 03, 12", "carlinhos", a1);
        Client client2 = new Client("Joao", "joaozinho","1999, 02, 19", "joao", a2);
        Client client3 = new Client("Maria", "maria","2004, 06, 01", "maria", a3);

        List<Client> allClients = new ArrayList<>();
        allClients.add(client1);
        allClients.add(client2);
        allClients.add(client3);

        Mockito.when(clientRepository.findAll()).thenReturn(allClients);

        List<Client> fromDB = clientService.getClients();

        Mockito.verify(clientRepository, VerificationModeFactory.times(1)).findAll();

        assertThat(fromDB).hasSize(allClients.size())
                          .extracting(Client::getName)
                          .containsExactly(client1.getName(), client2.getName(), client3.getName());
    }

    @Test
    public void findByUsername(){
        Address a1 = new Address("Rua do Louro", "Leiria", "Portugal", "4009-409");
        Client client = new Client("Carlos", "admin","2002, 03, 12", "carlinhos", a1);
        client.setUsername("anastácio");
        lenient().when(clientRepository.findByUsername("anastácio")).thenThrow(NoSuchElementException.class);
    }
}

