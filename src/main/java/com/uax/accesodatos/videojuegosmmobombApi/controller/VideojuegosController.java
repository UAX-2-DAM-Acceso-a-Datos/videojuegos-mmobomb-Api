package com.uax.accesodatos.videojuegosmmobombApi.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.services.VideojuegosService;

@Controller
public class VideojuegosController {
	
	@GetMapping("/")
	public String goToAllJuegos(Model modelo) {
		
		ArrayList <VideojuegosDTO> juegos = VideojuegosService.getListJuegos();
		modelo.addAttribute("juegos", juegos);
		
		return "index";
	}

}
