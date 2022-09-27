package com.dh.catalogservice.domain.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CatalogDTO {

    private String genre;
    private List<Movie> movies;
    private List<Serie> series;


    public CatalogDTO(String genre, List<Movie> movies, List<Serie> series) {
        this.genre = genre;
        this.movies = movies;
        this.series = series;
    }
}