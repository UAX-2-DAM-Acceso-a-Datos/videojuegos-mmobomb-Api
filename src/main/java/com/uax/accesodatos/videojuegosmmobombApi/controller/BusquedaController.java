package com.uax.accesodatos.videojuegosmmobombApi.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uax.accesodatos.videojuegosmmobombApi.dto.BusquedaParamsDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.services.VideojuegosService;

@Controller
public class BusquedaController {
	@GetMapping("/init-filter")
	public String init(Model model) {
		BusquedaParamsDTO searchArgs = new BusquedaParamsDTO();
		model.addAttribute("searchArgs", searchArgs);
		return "busquedaForm";
	}

	@PostMapping("/filter")
	public String filterVideojuegos(@ModelAttribute("searchArgs") BusquedaParamsDTO searchArgs) {
		ModelAndView view = new ModelAndView("index");
		ArrayList<VideojuegosDTO> videojuegos = VideojuegosService.getListJuegosFiltered(searchArgs.getCategory(),
				searchArgs.getPlatform());
		view.addObject("juegos", videojuegos);
		return "index";
	}
}
