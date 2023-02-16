package com.uax.accesodatos.videojuegosmmobombApi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.services.FavoritosService;

@Controller
public class FavoritosController {
	
	FavoritosService favoritosService;
	
	@GetMapping(value = "go-to-favoritos")
	public String goToFavoritos(@RequestParam("idUser") int idUser, Model model ) {
		List<VideojuegosDTO> juegos = favoritosService.getFavoritos(idUser);
		model.addAttribute("juegos", juegos);
		
		return "favoritos";
	}
	
	@GetMapping(value = "add/videojuego")
	public String addVideojuegoById(@RequestParam int idVideojuego, @RequestParam int idUsuario) {
		
		favoritosService.addFavorito(idVideojuego, idUsuario);
		
		return "redirect:/index";
	}
}
