package com.dh.serieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Season {

    private Long id;
    private Integer number;
    private List<Chapter> chapters;

}
