package com.uax.accesodatos.videojuegosmmobombApi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.uax.accesodatos.videojuegosmmobombApi.dto.BusquedaParamsDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.CategoriaDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.PlataformaDTO;
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

	@GetMapping("/filter")
	public String init(Model model) {
		BusquedaParamsDTO searchArgs = new BusquedaParamsDTO();
		
		model.addAttribute("searchArgs", searchArgs);
		model.addAttribute("categories", categRepo.getAllCategorias());
		model.addAttribute("platforms", platformRepo.getAllPlataformas());
		return "busquedaForm";
	}

	@GetMapping("/filtered")
	public String filterVideojuegos(@ModelAttribute("searchArgs") BusquedaParamsDTO searchArgs, Model model) {
		ArrayList<VideojuegosDTO> videojuegos = videojuegoService.getListJuegosFiltered(searchArgs.getCategory(),
				searchArgs.getPlatform());
		model.addAttribute("juegos", videojuegos);
		return "index";
	}
}
