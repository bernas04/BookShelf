package com.bookshelf.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.repository.ClientRepository;



@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Client> p = clientRepository.findByUsername(username);
		if (p==null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(p.get().getUsername(), p.get().getPassword(),
				new ArrayList<>());
	}

}
