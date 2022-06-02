package com.bookshelf.demo.services;

import java.util.List;

import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository UserRepository;

    public Client saveUser(Client User){
        return UserRepository.save(User);
    }

    public List<Client> getUsers(){
        return UserRepository.findAll();
    }

    public Client getUserById(Long id){
        return UserRepository.getReferenceById(id);
    }

    public void deleteUserById(Long id){
        UserRepository.deleteById(id);
    }
}
