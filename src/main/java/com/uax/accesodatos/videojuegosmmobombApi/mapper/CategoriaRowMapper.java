package com.uax.accesodatos.videojuegosmmobombApi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uax.accesodatos.videojuegosmmobombApi.dto.CategoriaDTO;

public class CategoriaRowMapper  implements RowMapper<CategoriaDTO>{
	@Override
	public CategoriaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoriaDTO categoria = new CategoriaDTO();
		
		categoria.setId_categoria(rs.getInt(1));
		categoria.setCategoria(rs.getString(2));
		return categoria;
	}
}