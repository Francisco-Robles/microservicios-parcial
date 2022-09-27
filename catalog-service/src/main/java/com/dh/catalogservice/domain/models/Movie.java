package com.dh.catalogservice.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "moviescatalog")
public class Movie {

    private String id;
    private String name;
    private String genre;
    private String urlStream;

}
