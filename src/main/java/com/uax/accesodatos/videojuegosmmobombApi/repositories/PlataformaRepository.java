package com.uax.accesodatos.videojuegosmmobombApi.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.uax.accesodatos.videojuegosmmobombApi.dto.PlataformaDTO;
import com.uax.accesodatos.videojuegosmmobombApi.mapper.PlataformaRowMapper;

public class PlataformaRepository {
	@Autowired
	private JdbcTemplate jdbctemplate;

	public List<PlataformaDTO> getAllPlataformas() {
		List<PlataformaDTO> plataformas = new ArrayList<PlataformaDTO>();
		plataformas = jdbctemplate.query("SELECT * FROM plataformas;", new PlataformaRowMapper());
		return plataformas;
	}
}
