package com.example.musiclib.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArtistDTO {
    private Long id;
    private String name;
    private String genre;

}
