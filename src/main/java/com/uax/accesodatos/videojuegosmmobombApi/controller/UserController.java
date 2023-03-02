package com.uax.accesodatos.videojuegosmmobombApi.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uax.accesodatos.videojuegosmmobombApi.dto.MailDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.services.UserService;
import com.uax.accesodatos.videojuegosmmobombApi.utils.VideojuegosUtils;

import jakarta.mail.MessagingException;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService = new UserService();
	
	@Autowired
	private VideojuegosUtils utils;


	@PostMapping(value = "/registrarUsuario")
	public ResponseEntity<String> register(@RequestBody UserDTO myUser) throws MessagingException {
		
		userService.registerUserDB(myUser);
		
		MailDTO mail = new MailDTO();
		//Se debe modificar los campos para que funcione
		mail.setTo("gerfernama@gmail.com");
		mail.setFrom("alozollo@myuax.com");
		mail.setAsunto("Account Created");
		
		Map<String, Object> propiedades = new HashMap<String, Object>();
		propiedades.put("name", myUser.getUsername());
		propiedades.put("subscriptionDate", LocalDate.now());
		
		mail.setProps(propiedades);
		
		utils.formarEmail(mail, "/emails/MailTemplate.html");
		
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
