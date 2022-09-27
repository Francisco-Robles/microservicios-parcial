package com.dh.catalogservice.api.service;

import java.util.Map;

public interface ICatalogService {
    Map<String, Object> getMovieByGenre (String genre);
}
