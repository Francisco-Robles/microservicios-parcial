package com.dh.gatewayservice.api.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @CircuitBreaker(name = "movieCB")
    @GetMapping("/movies")
    public ResponseEntity<String> moviesFallback() {
        return new ResponseEntity<>("No hay películas que mostrar. Inténtelo de nuevo.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CircuitBreaker(name = "serieCB")
    @GetMapping("/series")
    public ResponseEntity<String> seriesFallback() {
        return new ResponseEntity<>("No hay series que mostrar. Inténtelo de nuevo.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CircuitBreaker(name = "catalogCB")
    @GetMapping("/catalog")
    public ResponseEntity<String> catalogFallback() {
        return new ResponseEntity<>("No hay catálogo que mostrar. Inténtelo de nuevo.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
