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
import com.uax.accesodatos.videojuegosmmobombApi.dto.MinSysReqDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.ScreenshotDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.services.VideojuegosService;

@Controller
public class VideojuegosController {
	@Autowired
	VideojuegosService videojuegosService;
	
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
	/**
	 * @author Gonxos       
	 * @param model
	 * @return vista a la pantalla principal de todos los juegos
	 */
	
	@GetMapping("/juegos")
	public String goToAllJuegos(Model modelo) {
		
		ArrayList <VideojuegosDTO> juegos = videojuegosService.getListJuegos();
		modelo.addAttribute("juegos", juegos);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    modelo.addAttribute("username", username);
		
		return "index";
	}
	
	/**
	 * @author AlvaroLozoya 
	 * Metodo GET para hacer una llamada a la api con un id de un juego específico
	 * Realiza una comparación para ver si contiene requisitos minimos, en caso de que no muestra no 
	 * disponible y en caso de que devuelva la imagen erronea de League of Legends lo soluciona
	 *         
	 * @param model
	 * @return vista a la pantalla de juego
	 */
	@GetMapping("/go-to-id-juego")
	public String goToIdJuego(@RequestParam int id, Model model) {
		InfoVideojuegoDTO infoJuego = new InfoVideojuegoDTO();
		ArrayList<ScreenshotDTO> screenshot = new ArrayList<ScreenshotDTO>();
		
		infoJuego = videojuegosService.getInfoVideojuegoById(id);
		screenshot=infoJuego.getScreenshots();
		
		if (infoJuego.getMinimum_system_requirements() == null) {
			MinSysReqDTO minSysReqdto = new MinSysReqDTO("No Disponible");
			infoJuego.setMinimum_system_requirements(minSysReqdto);
		}
		
		for (int i = 0; i < infoJuego.getScreenshots().size(); i++) {
			ScreenshotDTO screen = new ScreenshotDTO(3, "");
			screen = screenshot.get(i);
			if (screen.getImage().equals("https://www.mmobomb.com/g/286/League-of-Legends-4.jpg")) {
				ScreenshotDTO image= new ScreenshotDTO(i, "https://www.mmobomb.com/g/286/League-of-Legends-3.jpg");
				
				screenshot.set(i, image);
				infoJuego.setScreenshots(screenshot);
			}
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    model.addAttribute("username", username);
		
		model.addAttribute("images", infoJuego.getScreenshots());
		model.addAttribute("infojuego", infoJuego);

		return "InfoJuego";
	}
	
	@GetMapping("/go-to-delete-juego")
	public String goToIdDJuego(@RequestParam int id, Model model) {
		InfoVideojuegoDTO infoJuego = new InfoVideojuegoDTO();
		ArrayList<ScreenshotDTO> screenshot = new ArrayList<ScreenshotDTO>();
		
		infoJuego = videojuegosService.getInfoVideojuegoById(id);
		screenshot=infoJuego.getScreenshots();
		
		if (infoJuego.getMinimum_system_requirements() == null) {
			MinSysReqDTO minSysReqdto = new MinSysReqDTO("No Disponible");
			infoJuego.setMinimum_system_requirements(minSysReqdto);
		}
		
		for (int i = 0; i < infoJuego.getScreenshots().size(); i++) {
			ScreenshotDTO screen = new ScreenshotDTO(3, "");
			screen = screenshot.get(i);
			if (screen.getImage().equals("https://www.mmobomb.com/g/286/League-of-Legends-4.jpg")) {
				ScreenshotDTO image= new ScreenshotDTO(i, "https://www.mmobomb.com/g/286/League-of-Legends-3.jpg");
				
				screenshot.set(i, image);
				infoJuego.setScreenshots(screenshot);
			}
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    model.addAttribute("username", username);
		
		model.addAttribute("images", infoJuego.getScreenshots());
		model.addAttribute("infojuego", infoJuego);

		return "InfoJuegoAniadido";
	}
	
	@RequestMapping(value = "/registrar")
	public String goToRegistrar(Model model) {
		UserDTO user = new UserDTO();
		model.addAttribute("user", user);
		return "registrar";
	}

}
