package com.uax.accesodatos.videojuegosmmobombApi.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.accesodatos.videojuegosmmobombApi.dto.InfoVideojuegoDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

	/**
	 * @author AlvaroLozoya
	 * Metodo GET para hacer una llamada a la api con un id de un juego específico
	 * 
	 * @param model
	 * @return vista a la pantalla de juego
	 */
	@GetMapping("/go-to-id-juego")
	public String goToLista(@RequestParam int id, Model model, HttpServletRequest request) {
		InfoVideojuegoDTO infoJuego = new InfoVideojuegoDTO();
		model.addAttribute("infovideojuego", infoJuego);
		
	

		return "InfoJuego";
	}
}
