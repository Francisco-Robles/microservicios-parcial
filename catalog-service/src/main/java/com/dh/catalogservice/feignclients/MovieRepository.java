package com.dh.catalogservice.feignclients;

import com.dh.catalogservice.domain.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findMoviesByGenre(String genre);

}
