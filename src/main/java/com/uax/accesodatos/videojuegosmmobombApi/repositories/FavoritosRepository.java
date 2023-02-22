package com.uax.accesodatos.videojuegosmmobombApi.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.mapper.FavoritosRowMapper;
import com.uax.accesodatos.videojuegosmmobombApi.mapper.IdRowMapper;

@Repository
public class FavoritosRepository {

	@Autowired
	private JdbcTemplate jdbctemplate = new JdbcTemplate();

	public List<VideojuegosDTO> getAllFavoritos(int user) {
		List<VideojuegosDTO> juegos = new ArrayList<VideojuegosDTO>();
		juegos = jdbctemplate.query("SELECT id_videojuego FROM favoritos WHERE id_user= " + user,
				new FavoritosRowMapper());
		return juegos;
	}

	public boolean addJuego(int juego, int id_user) {
		try {

			String sql = String
					.format("INSERT INTO favoritos (id_videojuego,id_user) VALUES('" + juego + "','" + id_user + "')");

			jdbctemplate.execute(sql);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean deleteJuego(VideojuegosDTO juego, int id_user) {

		try {

			String sql = String.format("DELETE FROM favoritos WHERE id_user='%d' AND id_videojuego='%d'", id_user,
					juego.getId());

			jdbctemplate.execute(sql);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public UserDTO getIdUser(String nombre) {
		UserDTO user = new UserDTO();
		user = jdbctemplate.queryForObject("SELECT id_user FROM users WHERE username= '" + nombre + "'",
				new IdRowMapper());
		return user;

	}

}
