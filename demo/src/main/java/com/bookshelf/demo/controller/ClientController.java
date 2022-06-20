package com.bookshelf.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.services.ClientService;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("http://localhost:3000")
public class ClientController {
    @Autowired
    public ClientService clientService;
    
    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @GetMapping("/Clients")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/bookEmail")
    public Optional<Client> getBookTitle(@RequestParam(value = "email") String email){
        return clientService.getBookByEmail(email);
    }

}
