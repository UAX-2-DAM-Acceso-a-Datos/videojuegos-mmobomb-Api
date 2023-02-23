package com.uax.accesodatos.videojuegosmmobombApi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	
	
	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;
	

	@Autowired    
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	UserDetails user;
    	
    	try {
    		//Recupera el usuario DB (username,password,roles)
    		final UserDTO usuarioDB = userRepository.findbyUsername(username);
    		
    		//Formamos el objeto userDetails (propio de string) para Spring
	        user = User.withUsername(username)
	        		.password(usuarioDB.getPassword())
	        		.roles(usuarioDB.getRoles())
	        		.build();
	        
	       
    		
    	}catch(EmptyResultDataAccessException e) {
    		return null;
    	}
    	
    	 return user;
    	
       
    }

    public boolean registerUserDB(UserDTO myUser) {
    	
    	List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(myUser.getRoles()));
		
		
		String encodededPassword = bCryptPasswordEncoder.encode(myUser.getPassword());
		
		User user = new User(myUser.getUsername(), encodededPassword, authorities);
		
		jdbcUserDetailsManager.createUser(user);
    	
		return true;
    	
    }

}
