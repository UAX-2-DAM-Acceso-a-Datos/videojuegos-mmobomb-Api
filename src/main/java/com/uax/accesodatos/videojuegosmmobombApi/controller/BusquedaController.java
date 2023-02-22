package com.uax.accesodatos.videojuegosmmobombApi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.uax.accesodatos.videojuegosmmobombApi.dto.BusquedaParamsDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.CategoriaRepository;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.PlataformaRepository;
import com.uax.accesodatos.videojuegosmmobombApi.services.VideojuegosService;

@Controller
public class BusquedaController {
	@Autowired
	CategoriaRepository categRepo;
	@Autowired
	PlataformaRepository platformRepo;
	@Autowired
	VideojuegosService videojuegoService;

	@GetMapping("/go-filter-form")
	public String goToFilterForm(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    UserDTO user = new UserDTO();
	    BusquedaParamsDTO searchArgs = new BusquedaParamsDTO();
	    
	    user.setUsername(username);

		model.addAttribute("username", username);
		model.addAttribute("searchArgs", searchArgs);
		model.addAttribute("categories", categRepo.getAllCategorias());
		model.addAttribute("platforms", platformRepo.getAllPlataformas());
		return "busquedaForm";
	}

	@GetMapping("/go-filtered-list")
	public String goFilteredVideojuegos(@ModelAttribute("searchArgs") BusquedaParamsDTO searchArgs, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    UserDTO user = new UserDTO();
		ArrayList<VideojuegosDTO> videojuegos = videojuegoService.getListJuegosFiltered(searchArgs.getCategory(),
				searchArgs.getPlatform());
		
		if (videojuegos.get(0) == null ) {
			VideojuegosDTO videojuego = new VideojuegosDTO();
			videojuego.title = "No disponible";
			videojuegos.add(videojuego);
		}
		
	    user.setUsername(username);

		model.addAttribute("username", username);
		model.addAttribute("juegos", videojuegos);
		Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
	    String username1 = auth1.getName();
	    UserDTO user1 = new UserDTO();
	    user1.setUsername(username1);
	    model.addAttribute("username", username1);
		return "index";
	}
}
