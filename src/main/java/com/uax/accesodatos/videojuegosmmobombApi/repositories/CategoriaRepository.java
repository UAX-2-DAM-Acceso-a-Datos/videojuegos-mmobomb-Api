package com.uax.accesodatos.videojuegosmmobombApi.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uax.accesodatos.videojuegosmmobombApi.dto.CategoriaDTO;
import com.uax.accesodatos.videojuegosmmobombApi.mapper.CategoriaRowMapper;
@Repository
public class CategoriaRepository {
	@Autowired
	private JdbcTemplate jdbctemplate;

	public List<CategoriaDTO> getAllCategorias() {
		List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
		categorias = jdbctemplate.query("SELECT * FROM categorias;", new CategoriaRowMapper());
		return categorias;
	}
}
