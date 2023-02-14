package com.uax.accesodatos.videojuegosmmobombApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class VideoJuegosController {
	
	
	public String goToAllJuegos(Model modelo) {
		
		return "index";
	}

}
