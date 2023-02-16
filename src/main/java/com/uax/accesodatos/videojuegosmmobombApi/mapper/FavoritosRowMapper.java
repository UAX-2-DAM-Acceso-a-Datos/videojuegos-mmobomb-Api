package com.uax.accesodatos.videojuegosmmobombApi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;

public class FavoritosRowMapper implements RowMapper<VideojuegosDTO>{
	@Override
	public VideojuegosDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		VideojuegosDTO videojuego = new VideojuegosDTO();
		
		videojuego.setId(rs.getInt(1));
		return videojuego;
	}
}
