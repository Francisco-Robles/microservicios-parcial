package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.Movie;

import java.util.Map;

public interface ICatalogService {
    Map<String, Object> getMovieByGenre (String genre);
}
