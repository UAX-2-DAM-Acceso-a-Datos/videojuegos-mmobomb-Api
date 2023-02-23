package com.uax.accesodatos.videojuegosmmobombApi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.uax.accesodatos.videojuegosmmobombApi.services.UserService;

@EnableWebSecurity
@Configuration
public class VideojuegosMmobombApiSecurity {

	private static final String USER = "USER";

	private static final String ADMIN = "ADMIN";
	@Autowired
	private VideojuegosMmobombApiAuthenticationProvider authProvider;

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserService();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(authProvider);
		return authenticationManagerBuilder.build();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider).userDetailsService(userDetailsService())
				.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests().requestMatchers("/juegos/**").authenticated().requestMatchers("/index").permitAll()
				.and().httpBasic().and().csrf().disable().formLogin().loginPage("/login")
				.loginProcessingUrl("/process-login").failureForwardUrl("/login_failure_handler")
				.successForwardUrl("/login_sucess_handler").defaultSuccessUrl("/juegos").failureUrl("/login?error");

//		http.authorizeRequests()
//		.requestMatchers("/admin").hasRole(ADMIN)
//		.requestMatchers("/user").hasAnyRole(ADMIN, USER)
//		.requestMatchers("/", "/register-user").permitAll()
//		.and().formLogin().and()
//		.logout().permitAll().and().httpBasic().and().csrf().disable();

		http.headers().frameOptions().sameOrigin();
		http.authenticationProvider(authenticationProvider());

		return http.build();

	}

	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource ds) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(ds);
		return jdbcUserDetailsManager;
	}

}
