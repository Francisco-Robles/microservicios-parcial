package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.ICatalogService;
import com.dh.catalogservice.domain.Catalog;
import com.dh.catalogservice.domain.models.CatalogDTO;
import com.dh.catalogservice.domain.models.Serie;
import com.dh.catalogservice.feignclients.MovieFeignClient;
import com.dh.catalogservice.domain.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatalogService {
    private MovieService movieService;
    private SerieService serieService;

    @Autowired
    public CatalogService(MovieService movieService, SerieService serieService) {
        this.movieService = movieService;
        this.serieService = serieService;
    }

    public CatalogDTO getCatalogFromGenre(String genre){

        List<Movie> moviesList = movieService.getAllMoviesByGenre(genre);
        List<Serie> seriesList = serieService.getAllMoviesByGenre(genre);

        return new CatalogDTO(genre,moviesList, seriesList);
    }
}
