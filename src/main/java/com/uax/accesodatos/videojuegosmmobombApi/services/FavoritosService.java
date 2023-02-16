package com.uax.accesodatos.videojuegosmmobombApi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.FavoritosRepository;

@Service
	public class FavoritosService {
	FavoritosRepository fr = new FavoritosRepository();
	
	public List<VideojuegosDTO> getFavoritos(int user){
		List<VideojuegosDTO> juegos;
		juegos = fr.getAllFavoritos(user);
		
		return juegos;
		
	}
	
	public boolean addFavorito(int idJuego, int idUser) {
		VideojuegosDTO juego = new VideojuegosDTO(idJuego);
		
		for(VideojuegosDTO existe: fr.getAllFavoritos(idUser)) {
			if (juego.getId() != existe.getId()) {
				fr.addJuego(juego, idUser);
			}
		}
		
		return true;
		
		
		
		
	}
	
	
	
}
