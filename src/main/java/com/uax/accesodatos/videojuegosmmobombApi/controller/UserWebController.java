package com.uax.accesodatos.videojuegosmmobombApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.services.UserService;


@Controller
public class UserWebController {
	
	@Autowired
	UserService userService;

	@GetMapping("/pantallaRegistro")
	public String irPantallaRegistro(Model model) {
		
		return "security/registrar";
	}
	
	@PostMapping("/pantallaRegistro")
	public String registrarUsuarioWeb(@ModelAttribute("usuario") UserDTO usuario) {
		
		usuario.setRoles("USER");
		userService.registerUserDB(usuario);
		
		return "login";
	}
}
