package com.uax.accesodatos.videojuegosmmobombApi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.FavoritosRepository;

@Service
public class FavoritosService {
	
	@Autowired
	FavoritosRepository fr;
	private final static String urlJuegoById = "https://www.mmobomb.com/api1/game?id=";
	
	public VideojuegosDTO juegoUser (int id_Juego) {
		Gson gson = new Gson();
		RestTemplate restT = new RestTemplate();
		String result = restT.getForObject(urlJuegoById+id_Juego, String.class);
		
		VideojuegosDTO videojuego = gson.fromJson(result, VideojuegosDTO.class);
		
		return videojuego;
	}
	
	public List<VideojuegosDTO> getFavoritos(String user){
		List<VideojuegosDTO> juegos;
		UserDTO usuario = fr.getIdUser(user);
		
		juegos = fr.getAllFavoritos(usuario.getId_user());
		List<VideojuegosDTO> juegosFavoritos = new ArrayList<VideojuegosDTO>();
		
		for(VideojuegosDTO total: juegos){
			total.setThumbnail(juegoUser(total.getId()).getThumbnail());
			total.setTitle(juegoUser(total.getId()).getTitle());
			juegosFavoritos.add(total);
		}
		
		return juegosFavoritos;
		
	}

	
	public boolean addFavorito(int idJuego, int idUser, String username) {
		VideojuegosDTO juego = new VideojuegosDTO(idJuego);
		
		for(VideojuegosDTO existe: fr.getAllFavoritos(idUser)) {
			if (juego.getId() != existe.getId()) {
				fr.addJuego(juego, idUser);
			}
		}
		
		return true;		
	}
	
	
	
}
