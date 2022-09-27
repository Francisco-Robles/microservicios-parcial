package com.dh.serieservice.api.controller;

import com.dh.serieservice.api.service.SerieService;
import com.dh.serieservice.model.Serie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping()
    public ResponseEntity<?> findAllSerie(){
        log.info("Buscando series...");
        return ResponseEntity.ok().body(serieService.getAllSerie());
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> findAllSerieByGenre(@PathVariable String genre){
        log.info("Buscando las series con el género: "+ genre);
        return ResponseEntity.ok().body(serieService.findAllByGenre(genre));
    }

    @PostMapping("/save")
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie) {
        log.info("Agregando la serie: "+ serie);
        return ResponseEntity.ok().body(serieService.saveSerie(serie));
    }

}
