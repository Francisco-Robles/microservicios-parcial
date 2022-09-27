package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.domain.models.Serie;
import com.dh.catalogservice.feignclients.SerieFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SerieService {

    private SerieFeignClient serieFeignClient;

    public SerieService(SerieFeignClient serieFeignClient) {
        this.serieFeignClient = serieFeignClient;
    }

    public List<Serie> getAllSeries(){
        return serieFeignClient.getSeries();
    }

    @CircuitBreaker(name = "catalogFromGenre",fallbackMethod = "moviesSerieFallbackMethod")
    @Retry(name = "catalogFromGenre")
    public List<Serie> getAllMoviesByGenre(String genre){
        return serieFeignClient.getSeriesByGenre(genre);
    }

    public Serie saveMovie(Serie serie){
        return serieFeignClient.saveSerie(serie);
    }

    private void moviesSerieFallbackMethod(){
        log.error("El circuit breaker fue activado.");
    }
}
