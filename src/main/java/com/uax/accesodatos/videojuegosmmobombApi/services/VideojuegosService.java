package com.uax.accesodatos.videojuegosmmobombApi.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.uax.accesodatos.videojuegosmmobombApi.dto.InfoVideojuegoDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;



@Service
public class VideojuegosService {
	
	private final static String urlJuegosRandom = "https://www.mmobomb.com/api1/games";
	private final static String urlJuegoById = "https://www.mmobomb.com/api1/game?id=";
	
	RestTemplate restT;
	Gson gson;
	
	
	public static VideojuegosDTO getVideojuegoFromApi() {
		RestTemplate restT = new RestTemplate();
		
		VideojuegosDTO juego = restT.getForObject(urlJuegosRandom, VideojuegosDTO.class);
		
		return juego;
		
		
	}
	
	public static ArrayList<VideojuegosDTO> getListJuegos() {
		
		ArrayList<VideojuegosDTO> juegos = new ArrayList<VideojuegosDTO>();
		
		for(int i = 0; i <= 30; i++) {
			juegos.add(getVideojuegoFromApi());
			
		}
		
		return juegos;
		
	}
	
	public InfoVideojuegoDTO getInfoVideojuegoById(int id) {
		Gson gson = new Gson();
		RestTemplate restT = new RestTemplate();
		String result = restT.getForObject(urlJuegoById+id, String.class);
		
		InfoVideojuegoDTO videojuego = gson.fromJson(result, InfoVideojuegoDTO.class);
		
		return videojuego;
	}
	

}
