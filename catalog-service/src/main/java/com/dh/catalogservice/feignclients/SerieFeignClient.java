package com.dh.catalogservice.feignclients;

import com.dh.catalogservice.domain.models.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "serie-service", path = "/series")
public interface SerieFeignClient {

    @GetMapping("/{genre}")
    List<Serie> getSeriesByGenre(@PathVariable String genre);

    @PostMapping("/save")
    Serie saveSerie(@RequestBody Serie serie);

    @GetMapping()
    List<Serie> getSeries();

}
