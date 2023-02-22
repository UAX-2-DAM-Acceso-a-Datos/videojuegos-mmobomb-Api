package com.uax.accesodatos.videojuegosmmobombApi.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.uax.accesodatos.videojuegosmmobombApi.dto.InfoVideojuegoDTO;
import com.uax.accesodatos.videojuegosmmobombApi.dto.VideojuegosDTO;

/**
 * @author Gonzalo
 *
 */
@Service
public class VideojuegosService {

	private final static String URLJUEGOSRANDOM = "https://www.mmobomb.com/api1/games";
	private final static String URLJUEGOBYID = "https://www.mmobomb.com/api1/game?id=";

	/**
	 * @author Gonzalo
	 * @param result
	 * @return
	 * @throws JsonSyntaxException
	 */
	public static ArrayList<VideojuegosDTO> getResponseByString(String result) throws JsonSyntaxException {
		ArrayList<VideojuegosDTO> juegos;
		Gson gson = new Gson();
		juegos = gson.fromJson(result, ArrayList.class);

		return juegos;

	}

	/**
	 * @author Gonzalo
	 * @return
	 */
	public static ArrayList<VideojuegosDTO> getListJuegos() {
		RestTemplate restT = new RestTemplate();
		ArrayList<VideojuegosDTO> juegos = new ArrayList<VideojuegosDTO>();
		String result = restT.getForObject(URLJUEGOSRANDOM, String.class);

		juegos = getResponseByString(result);

		return juegos;
	}

	/**
	 * @author AlvaroLozoya
	 * 
	 *         Método para obtener de la api toda la info de un videojuego
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
	public static ArrayList<VideojuegosDTO> getListJuegosFiltered(String categoria, String platform) {
		RestTemplate restT = new RestTemplate();
		ArrayList<VideojuegosDTO> juegos = new ArrayList<VideojuegosDTO>();

		String url = URLJUEGOSRANDOM + "?";
		if (categoria != null && platform != null) {
			url += "category=" + categoria + "&platform=" + platform;
		} else if (categoria != null) {
			url += "category=" + categoria;
		} else if (platform != null) {
			url += "platform=" + platform;
		} else {
			url = URLJUEGOSRANDOM;
		}
		
		String result = restT.getForObject(url, String.class);

		juegos = getResponseByString(result);

		return juegos;
	}
}
