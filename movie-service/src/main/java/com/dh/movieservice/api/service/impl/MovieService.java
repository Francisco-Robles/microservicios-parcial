package com.dh.movieservice.api.service.impl;

import com.dh.movieservice.api.service.IMovieService;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return repository.findByGenre(genre);
    }

    @Override
    public Movie save(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public List<Movie> getAll(){
        return repository.findAll();
    }

}
