package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.impl.MovieService;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.queue.MovieSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;
    private final MovieSender movieSender;

    public MovieController(MovieService service, MovieSender movieSender) {
        this.service = service;
        this.movieSender = movieSender;
    }

    @GetMapping("/byGenre/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        log.info("Buscando las películas con el género: " + genre);
        return ResponseEntity.ok().body(service.getMoviesByGenre(genre));
    }

    @PostMapping("/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        log.info("Agregando la película: " + movie);
        return ResponseEntity.ok().body(movieSender.send(movie));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Movie>> getMovies (){
        log.info("Buscando todas las películas...");
        return ResponseEntity.ok().body(service.getAll());
    }

}
