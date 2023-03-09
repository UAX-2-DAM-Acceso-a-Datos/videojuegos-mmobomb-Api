package com.uax.accesodatos.videojuegosmmobombApi.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.uax.accesodatos.videojuegosmmobombApi.dto.NewsDTO;

@Repository
public interface FavoritoMongoDBRepository extends MongoRepository<NewsDTO, String> {
	
	Optional<NewsDTO> findById(String id);


}
