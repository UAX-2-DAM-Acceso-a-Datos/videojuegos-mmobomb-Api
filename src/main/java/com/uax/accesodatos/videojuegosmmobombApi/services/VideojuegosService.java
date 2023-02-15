package com.uax.accesodatos.videojuegosmmobombApi.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;


@Service
public class VideojuegosService {
	
	private final static String urlJuegosRandom = "https://www.mmobomb.com/api1/games";
	

	RestTemplate restT;
	Gson gson;
	
	public static ArrayList<VideojuegosDTO> getResponseByString(String result) throws JsonSyntaxException {
		ArrayList<VideojuegosDTO>juegos;
		Gson gson = new Gson();
		juegos = gson.fromJson(result, ArrayList.class);
		
		return juegos;
		
	}
	
	
	public static ArrayList<VideojuegosDTO> getListJuegos() {
		RestTemplate restT = new RestTemplate();
		ArrayList<VideojuegosDTO> juegos = new ArrayList<VideojuegosDTO>();
		String result = restT.getForObject(urlJuegosRandom, String.class);
		
		juegos = getResponseByString(result);
		
		return juegos;
		
	}
	
	

}
