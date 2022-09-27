package com.dh.movieservice.api.service;

import com.dh.movieservice.domain.model.Movie;

import java.util.List;

public interface IMovieService {

    List<Movie> getMoviesByGenre(String genre);
    List<Movie> getAll();
    Movie save (Movie movie);

}
