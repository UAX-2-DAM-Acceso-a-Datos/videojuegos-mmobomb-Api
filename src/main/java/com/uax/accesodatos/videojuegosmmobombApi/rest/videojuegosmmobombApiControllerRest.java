package com.uax.accesodatos.videojuegosmmobombApi.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uax.accesodatos.videojuegosmmobombApi.dto.CategoriaDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.PlataformaDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.mapper.FavoritosRowMapper;
import com.uax.accesodatos.videojuegosmmobombApi.mapper.PlataformaRowMapper;
import com.uax.accesodatos.videojuegosmmobombApi.mapper.UserRowMapper;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.CategoriaRepository;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.FavoritosRepository;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.PlataformaRepository;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.UserRepository;

@RequestMapping("/api")
@RestController
public class videojuegosmmobombApiControllerRest {
	
	@Autowired
	CategoriaRepository categoriarepository;
	PlataformaRepository plataformarepository;
	FavoritosRepository favoritosrepository;
	UserRepository userrepository;
	
	@GetMapping("/categorias")
	public List<CategoriaDTO> getAllCategorias(){
		return categoriarepository.getAllCategorias();
	}
	
	@GetMapping("/plataformas")
	public List<PlataformaDTO> getAllPlataformas() {
		return plataformarepository.getAllPlataformas();
	}
	
	@GetMapping("/favoritos?id=")
	public List<VideojuegosDTO> getAllFavoritos(@RequestParam int user) {
		return favoritosrepository.getAllFavoritos(user);
	}
	
	@GetMapping("/usuarios")
	public 	UserDTO findbyUsername(String nombre) {
		return userrepository.findbyUsername(nombre);
		
	}
	

}
