package com.uax.accesodatos.videojuegosmmobombApi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.uax.accesodatos.videojuegosmmobombApi.dto.NewsMdbDTO;

@Repository
public interface VideojuegosMongoDB extends MongoRepository<NewsMdbDTO, String>{
	
}
