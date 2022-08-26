package com.dh.catalogservice.api.service;

import com.dh.catalogservice.api.feignclients.MovieFeignClient;
import com.dh.catalogservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CatalogService implements ICatalogService {
    private final RestTemplate clienteRest;
    @Autowired
    MovieFeignClient movieFeignClient;

    public CatalogService(RestTemplate clienteRest) {
        this.clienteRest = clienteRest;
    }

    @Override
    public Map<String, Object> getMovieByGenre(String genre) {

        var url = String.format("http://localhost:8001/movies/byGenre/%s", genre);

        /*var response = clienteRest.exchange(url, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Movie>>() {
                });*/

        Map<String, Object> result = new HashMap<>();
        List<Movie> movies = movieFeignClient.getMoviesByGenre(genre);

        if (movies.isEmpty()){
            result.put("Mensaje", "No hay películas con ese género.");
            return result;
        }else{

            result.put("Género: ", genre);
            result.put("Películas: ", movies);
            return result;

        }

        //return Objects.requireNonNull(response.getBody());

    }
}
