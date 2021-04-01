package br.com.zup.Squad.planoestudo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanoEstudoResponseDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("titulo")
    private String titulo;

    public PlanoEstudoResponseDTO(PlanoEstudo planoEstudo) {
        this.id=planoEstudo.getId();
        this.titulo=planoEstudo.getTitulo();
    }
}
