package com.uax.accesodatos.videojuegosmmobombApi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;


public class UserRowMapper implements RowMapper<UserDTO>{
	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDTO user = new UserDTO();
		
		user.setId_user(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setPassword(rs.getString(2));
		
		return user;
	}
}
