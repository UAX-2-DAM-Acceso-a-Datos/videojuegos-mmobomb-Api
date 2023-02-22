package com.uax.accesodatos.videojuegosmmobombApi.controller;

import java.util.List;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.services.FavoritosService;

@Controller
public class FavoritosController {
	
	@Autowired
	FavoritosService favoritosService;
	FavoritosRepository fr = new FavoritosRepository();
	
	@GetMapping("/go-to-favoritos")
	public String goToFavoritos(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    UserDTO user = new UserDTO();
	    user.setUsername(username);
	    
	    model.addAttribute("username", username);
		List<VideojuegosDTO> juegos = favoritosService.getFavoritos(username);
		
		model.addAttribute("juegos", juegos);
		
		return "favoritos";
	}
	
	@GetMapping("/addFavorito")
	public String addVideojuegoById(@RequestParam("id") int idVideojuego) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();

		favoritosService.addFavorito(idVideojuego, favoritosService.getIdUser(username));
		
		return "redirect:/juegos";
	}
	
	@GetMapping("/deleteFavorito")
	public String deleteVideojuegoById(@RequestParam("id") int idVideojuego) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    
		favoritosService.deleteFavorito(idVideojuego, favoritosService.getIdUser(username));
		
		return "redirect:/juegos";
	}
}
