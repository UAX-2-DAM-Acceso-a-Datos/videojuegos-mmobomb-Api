package com.uax.accesodatos.videojuegosmmobombApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.services.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService = new UserService();


	@PostMapping(value = "/registrarUsuario")
	public ResponseEntity<String> register(@RequestBody UserDTO myUser) {
		
		userService.registerUserDB(myUser);
		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@GetMapping(value = "/admin")
	public String admin() {
		return "<h3>Bienvenido Admin </h3>";
	}

	@GetMapping(value = "/user")
	public String user() {
		return "<h3>Bienvenido usuario</h3>";
	}
	

}
