package br.com.zup.Squad.planoestudo;

import br.com.zup.Squad.validation.UniqueValueValid;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PlanoEstudoRequestDTO {
    @JsonProperty("titulo")
    @NotBlank
    private String titulo;

    @JsonProperty("descricao")
    @NotBlank
    @UniqueValueValid(classe = PlanoEstudo.class,field = "descricao")
    private String descricao;

    public PlanoEstudoRequestDTO(@NotBlank String titulo, @NotBlank String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
    public PlanoEstudo converter(){
        return new PlanoEstudo(this.titulo,this.descricao);
    }
}
