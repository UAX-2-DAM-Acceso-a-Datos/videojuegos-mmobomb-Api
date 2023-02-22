package com.uax.accesodatos.videojuegosmmobombApi.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyErrorsController implements ErrorController {
	
	@RequestMapping("/error")
	public String showError404Generic(Exception ex, HttpServletResponse req) {
		
		String vista="";
		
		switch(req.getStatus()) {
		
		case HttpServletResponse.SC_NOT_FOUND: {
			vista = "404error";
			break;
		}
		case HttpServletResponse.SC_INTERNAL_SERVER_ERROR: {
			vista = "505error";
			break;
		}
		
		}
		
		return vista;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView showPageErrorGeneric(Exception e) {
		ModelAndView modelo = new ModelAndView();
		
		modelo.setViewName("ExceptionPage");
		return modelo;
	}
	

}
