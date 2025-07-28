package br.com.mateus.springboot2_essentials.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Anime {
    private Long id ;
    private String name ;

}
