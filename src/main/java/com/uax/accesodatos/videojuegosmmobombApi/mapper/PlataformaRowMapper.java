package com.uax.accesodatos.videojuegosmmobombApi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uax.accesodatos.videojuegosmmobombApi.dto.PlataformaDTO;

public class PlataformaRowMapper  implements RowMapper<PlataformaDTO>{
	@Override
	public PlataformaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PlataformaDTO plataforma = new PlataformaDTO();
		plataforma.setId_plataforma(rs.getInt(1));
		plataforma.setPlataforma(rs.getString(2));
		return plataforma;
	}
}