package com.uax.accesodatos.videojuegosmmobombApi.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.uax.accesodatos.videojuegosmmobombApi.dto.Mail;
import com.uax.accesodatos.videojuegosmmobombApi.dto.UserDTO;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.UserRepository;
import com.uax.accesodatos.videojuegosmmobombApi.utils.UserUtils;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserUtils utils;

	@Autowired
    private UserRepository userRepository;
	
	
	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;
	

	@Autowired    
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	    
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

        User user = new User(myUser.getUsername(), encodededPassword, false, false, false, false, authorities);

        enviarEmailVerificacion(myUser);

        jdbcUserDetailsManager.createUser(user);

        return true;

    }

    public void enviarEmailVerificacion(UserDTO user) {
        Mail mail = new Mail();
        mail.setTo("slaclaustralopez@gmail.com");
        mail.setForm("slaclaustralopez@gmail.com");
        mail.setAsunto("Prueba envio email");
        Map<String, Object> propiedades = new HashMap<>();
        propiedades.put("subscriptionDate", LocalDate.now().toString());

        mail.setProps(propiedades);

        utils.formarEmail(mail, "/emails/plantillaEmail");
    }
    



}
