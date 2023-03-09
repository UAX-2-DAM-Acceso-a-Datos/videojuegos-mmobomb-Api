package com.uax.accesodatos.videojuegosmmobombApi.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.uax.accesodatos.videojuegosmmobombApi.dto.InfoVideojuegoDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.NewsDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;
import com.uax.accesodatos.videojuegosmmobombApi.repositories.FavoritoMongoDBRepository;

/**
 * @author Gonzalo
 *
 */
@Service
public class VideojuegosService {
	
	@Autowired
	FavoritoMongoDBRepository fmdb;

	private final static String URLJUEGOSRANDOM = "https://www.mmobomb.com/api1/games";
	private final static String URLJUEGOBYID = "https://www.mmobomb.com/api1/game?id=";
	private final static String URLNEWS = "https://www.mmobomb.com/api1/latestnews";

	/**
	 * @author Gonzalo
	 * @param result
	 * @return
	 * @throws JsonSyntaxException
	 */
	public ArrayList<VideojuegosDTO> getResponseByString(String result) throws JsonSyntaxException {
		ArrayList<VideojuegosDTO> juegos;
		Gson gson = new Gson();
		juegos = gson.fromJson(result, ArrayList.class);

		return juegos;

	}
	
	public List<NewsDTO> getResponseByStringN(String result) throws JsonSyntaxException, JsonMappingException, JsonProcessingException {
		List<NewsDTO> news;
	
		ObjectMapper objectMapper = new ObjectMapper();
		NewsDTO[] arrayNews = objectMapper.readValue(result, NewsDTO[].class);
		news = Arrays.asList(arrayNews);
		
		return news;

	}

	/**
	 * @author Gonzalo
	 * @return
	 */
	public ArrayList<VideojuegosDTO> getListJuegos() {
		RestTemplate restT = new RestTemplate();
		ArrayList<VideojuegosDTO> juegos = new ArrayList<VideojuegosDTO>();
		String result = restT.getForObject(URLJUEGOSRANDOM, String.class);

		juegos = getResponseByString(result);

		return juegos;
	}
	
	public List<NewsDTO> getListNews() throws JsonMappingException, JsonSyntaxException, JsonProcessingException {
		
		RestTemplate restT = new RestTemplate();
		
		String result = restT.getForObject(URLNEWS, String.class);

		return getResponseByStringN(result);
	}
	
	public void insertAllNews() throws JsonMappingException, JsonSyntaxException, JsonProcessingException {
		List<NewsDTO> news = getListNews();
		fmdb.deleteAll();
		
		for (int i = 0; i < news.size(); i++) {
			NewsDTO noticia = news.get(i);
			fmdb.save(noticia);
		}
		
	}
	
//	public NewsDTO randomNews() {
//		ArrayList<NewsDTO> news = getListNews();
//		
//		
//	}
	
	/**
	 * @author AlvaroLozoya
	 * 
	 *         Método para obtener de la api toda la info de un videojuego, también implementa
	 *         la funcionalidad para quitar las etiquetas html que devuelve la api en la descripción
	 * 
	 * @param id
	 * @return InfoVideojuegoDTO
	 */
	public InfoVideojuegoDTO getInfoVideojuegoById(int id) {
		Gson gson = new Gson();
		RestTemplate restT = new RestTemplate();
		String result = restT.getForObject(URLJUEGOBYID + id, String.class);

		InfoVideojuegoDTO videojuego = gson.fromJson(result, InfoVideojuegoDTO.class);
		
		String html = videojuego.getDescription();
		videojuego.setDescription(html.replaceAll("<[^>]*>", ""));
		
		return videojuego;
	}

	/**
	 * @author Edu
	 * 
	 *         coger de la api la lista filtrada por categoria o plataforma
	 * 
	 * @param categoria
	 * @param platform
	 * @return
	 */
	public ArrayList<VideojuegosDTO> getListJuegosFiltered(String categoria, String platform) {
		RestTemplate restT = new RestTemplate();
		ArrayList<VideojuegosDTO> juegos = new ArrayList<VideojuegosDTO>();

		if (platform.equals("PC (Windows)")) {
			platform = "pc";
		}else if (platform.equals("Web Browser")) {
			platform = "browser";
		}

		
		String url = URLJUEGOSRANDOM;
		if (!categoria.equals("") && !platform.equals("")) {
			url += "?category=" + categoria + "&platform=" + platform;
		} else if (!categoria.equals("")) {
			url += "?category=" + categoria;
		} else if (!platform.equals("")) {
			url += "?platform=" + platform;
		} else {
			url = "https://www.mmobomb.com/api1/games";
		}
		
		String resp = restT.getForObject(url, String.class);
		
		juegos = getResponseByString(resp);

		return juegos;
	}
}
