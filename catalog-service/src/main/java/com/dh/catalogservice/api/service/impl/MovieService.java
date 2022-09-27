package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.domain.models.Movie;
import com.dh.catalogservice.feignclients.MovieFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieService {

    private MovieFeignClient movieFeignClient;

    @Autowired
    public MovieService (MovieFeignClient movieFeignClient){
        this.movieFeignClient = movieFeignClient;
    }

    public List<Movie> getAllMovies(){
        return movieFeignClient.getMovies();
    }

    @CircuitBreaker(name = "catalogFromGenre",fallbackMethod = "moviesSerieFallbackMethod")
    @Retry(name = "catalogFromGenre")
    public List<Movie> getAllMoviesByGenre(String genre){
        return movieFeignClient.getMoviesByGenre(genre);
    }

    public Movie saveMovie(Movie movie){
        return movieFeignClient.saveMovie(movie);
    }

    private void moviesSerieFallbackMethod(){
        log.error("El circuit breaker fue activado.");
    }


}
