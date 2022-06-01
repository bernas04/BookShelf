package com.bookshelf.demo.services;

import java.util.List;

import com.bookshelf.demo.model.User;
import com.bookshelf.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository UserRepository;

    public User saveUser(User User){
        return UserRepository.save(User);
    }

    public List<User> getUsers(){
        return UserRepository.findAll();
    }

    public User getUserById(Long id){
        return UserRepository.getReferenceById(id);
    }

    public void deleteUserById(Long id){
        UserRepository.deleteById(id);
    }
}
