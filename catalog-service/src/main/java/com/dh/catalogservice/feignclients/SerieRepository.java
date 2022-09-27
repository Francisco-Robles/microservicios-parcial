package com.dh.catalogservice.feignclients;

import com.dh.catalogservice.domain.models.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends MongoRepository<Serie, String> {

    List<Serie> findSeriesByGenre(String genre);

}
