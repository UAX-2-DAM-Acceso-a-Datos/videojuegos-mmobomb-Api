package com.uax.accesodatos.videojuegosmmobombApi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.accesodatos.videojuegosmmobombApi.dto.InfoVideojuegoDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.services.VideojuegosService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class VideojuegosController {
	@Autowired
	VideojuegosService videojuegosservice;
	
	@GetMapping("/")
	public String goToAllJuegos(Model modelo) {
		
		ArrayList <VideojuegosDTO> juegos = VideojuegosService.getListJuegos();
		modelo.addAttribute("juegos", juegos);
		
		return "index";
	}
	
	/**
	 * @author AlvaroLozoya 
	 * Metodo GET para hacer una llamada a la api con un id de un juego específico
	 *         
	 * @param model
	 * @return vista a la pantalla de juego
	 */
	@GetMapping("/go-to-id-juego")
	public String goToIdJuego(@RequestParam int id, Model model, HttpServletRequest request) {
		InfoVideojuegoDTO infoJuego = new InfoVideojuegoDTO();
		
		infoJuego = videojuegosservice.getInfoVideojuegoById(id);
		
		model.addAttribute("infovideojuego", infoJuego);

		return "InfoJuego";
	}

}
