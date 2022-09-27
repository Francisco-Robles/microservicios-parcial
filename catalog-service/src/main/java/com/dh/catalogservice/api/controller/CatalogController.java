package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.impl.CatalogService;
import feign.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }


    @GetMapping("/getGenre/{genre}")
    public ResponseEntity<?> getCatalogFromGenre(@PathVariable String genre){

        return ResponseEntity.ok().body(service.getCatalogFromGenre(genre));

    }

}
