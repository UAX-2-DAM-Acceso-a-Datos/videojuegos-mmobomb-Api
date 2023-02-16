package com.uax.accesodatos.videojuegosmmobombApi.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.mapper.FavoritosRowMapper;

@Repository
public class FavoritosRepository {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public List<VideojuegosDTO> getAllFavoritos(int user) {
		List<VideojuegosDTO> juegos = new ArrayList<VideojuegosDTO>();
		juegos = jdbctemplate.query("SELECT id_videojuego FROM favoritos WHERE id_user= "+user, new FavoritosRowMapper());
		return juegos;
	}
	
	public boolean addJuego(VideojuegosDTO juego, int id_user) {
		try {
			String sql = String.format("INSERT INTO favoritos (id_videojuego,id_user) VALUES('%d','%d')", juego.getId(), id_user);
			jdbctemplate.execute(sql);
		}catch (Exception e) {
			return false;
		}
		return true;
		
		
	}
	
}
