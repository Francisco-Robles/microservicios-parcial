package com.dh.catalogservice.feignclients;

import com.dh.catalogservice.domain.models.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "movie-service", path = "/movies")
public interface MovieFeignClient {

    @GetMapping("/byGenre/{genre}")
    List<Movie> getMoviesByGenre(@PathVariable("genre") String genre);

    @PostMapping("/save")
    Movie saveMovie(@RequestBody Movie movie);

    @GetMapping("/getAll")
    List<Movie> getMovies();

}
