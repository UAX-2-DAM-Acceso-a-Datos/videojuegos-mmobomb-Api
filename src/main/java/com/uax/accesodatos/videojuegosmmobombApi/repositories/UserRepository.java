package com.uax.accesodatos.videojuegosmmobombApi.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uax.accesodatos.videojuegosmmobombApi.mapper.UserRowMapper;
import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;

@Repository
public class UserRepository{
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	public 	UserDTO findbyUsername(String nombre) {
		String sql=String.format("SELECT u.username, u.password, a.authority from users u, authorities a where u.username=a.username and u.username= '%s'",nombre);
		return jdbctemplate.queryForObject(sql, new UserRowMapper());
		
	}


}
