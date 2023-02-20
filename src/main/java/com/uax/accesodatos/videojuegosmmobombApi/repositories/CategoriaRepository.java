package com.uax.accesodatos.videojuegosmmobombApi.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.uax.accesodatos.videojuegosmmobombApi.dto.CategoriaDTO;
import com.uax.accesodatos.videojuegosmmobombApi.mapper.CategoriaRowMapper;

public class CategoriaRepository {
	@Autowired
	private JdbcTemplate jdbctemplate;

	public List<CategoriaDTO> getAllCategorias(int user) {
		List<CategoriaDTO> juegos = new ArrayList<CategoriaDTO>();
		juegos = jdbctemplate.query("SELECT * FROM categorias;", new CategoriaRowMapper());
		return juegos;
	}
}
