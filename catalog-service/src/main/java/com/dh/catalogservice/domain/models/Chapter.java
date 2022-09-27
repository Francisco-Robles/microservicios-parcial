package com.dh.catalogservice.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class Chapter {

    private Integer id;
    private String name;
    private Integer number;
    private String urlStream;

}
