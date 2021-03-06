package com.bookshelf.demo.services;

import java.util.List;
import java.util.Optional;

import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    public ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public Client saveClient(Client client){
        client.setPassword(bcryptEncoder.encode(client.getPassword()));
        return clientRepository.save(client);
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(Long id){
        return clientRepository.getReferenceById(id);
    }

    public String deleteClientById(Long id){
        clientRepository.deleteById(id);
        return "Client deleted!";
    }

    public Optional<Client> getBookByEmail(String username){
        return clientRepository.findByUsername(username);
    }
}
