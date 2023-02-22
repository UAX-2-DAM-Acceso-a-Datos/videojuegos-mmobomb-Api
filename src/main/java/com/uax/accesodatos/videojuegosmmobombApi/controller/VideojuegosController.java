package com.uax.accesodatos.videojuegosmmobombApi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.accesodatos.videojuegosmmobombApi.dto.InfoVideojuegoDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.services.VideojuegosService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class VideojuegosController {
	@Autowired
	VideojuegosService videojuegosservice;
	
	@RequestMapping(value="/login")
	public String goLogin(Model model) {
		
		UserDTO user = new UserDTO();
		model.addAttribute("user", user);
		return "login";
	}
	
	@GetMapping("/")
	public String home(Model modelo) {
		
		return "redirect:/login";
	}
	
	@GetMapping("/juegos")
	public String goToAllJuegos(Model modelo) {
		
		ArrayList <VideojuegosDTO> juegos = VideojuegosService.getListJuegos();
		modelo.addAttribute("juegos", juegos);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    modelo.addAttribute("username", username);
		
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
	
	@RequestMapping(value = "/registrar")
	public String goToRegistrar(Model model) {
		UserDTO user = new UserDTO();
		model.addAttribute("user", user);
		return "registrar";
	}

}
