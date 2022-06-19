package com.bookshelf.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.demo.configuration.JwtTokenUtil;
import com.bookshelf.demo.model.Client;
import com.bookshelf.demo.model.JwtRequest;
import com.bookshelf.demo.repository.ClientRepository;
import com.bookshelf.demo.services.ClientService;
import com.bookshelf.demo.services.JwtUserDetailsService;



@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ClientRepository repository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private ClientService clientService;


	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		Client p = repository.findByUsername(authenticationRequest.getUsername()).get();

		final String token = jwtTokenUtil.generateToken(userDetails);
		p.setToken(token);
		
		return ResponseEntity.ok(p);
	}


	@RequestMapping(value = "/registerClient", method = RequestMethod.POST)
	public ResponseEntity<?> saveManager(@RequestBody Client m) throws Exception {
		Client c =clientService.saveClient(m);
		return ResponseEntity.ok(c);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}

