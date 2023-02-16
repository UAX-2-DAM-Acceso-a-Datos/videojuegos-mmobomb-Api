package com.uax.accesodatos.videojuegosmmobombApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.services.FavoritosService;

@Controller
public class FavoritosController {
	
	@Autowired
	FavoritosService favoritosService;
	
	@GetMapping("/go-to-favoritos")
	public String goToFavoritos(Model model ) {
		List<VideojuegosDTO> juegos = favoritosService.getFavoritos(1);
		model.addAttribute("juegos", juegos);
		
		return "favoritos";
	}
	
	@GetMapping("/addFavorito")
	public String addVideojuegoById(@RequestParam("id") int idVideojuego) {
		
		favoritosService.addFavorito(idVideojuego, 1);
		
		return "redirect:/";
	}
}
