package com.uax.accesodatos.videojuegosmmobombApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FavoritosController {
	
	@GetMapping(value = "go-to-favoritos")
	public String goToFavoritos(Model model) {
		
		return "favoritos";
	}
	
	@GetMapping(value = "add/videojuego")
	public String addVideojuegoById(@RequestParam("idVideojuego") int idVideojuego) {
		
		
		return "redirect:/index";
	}
}
