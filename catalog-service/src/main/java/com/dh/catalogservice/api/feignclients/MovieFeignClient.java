package com.dh.catalogservice.api.feignclients;

import com.dh.catalogservice.domain.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "movie-service", path = "/movies")
public interface MovieFeignClient {

    @GetMapping("/byGenre/{genre}")
    List<Movie> getMoviesByGenre(@PathVariable("genre") String genre);

}
