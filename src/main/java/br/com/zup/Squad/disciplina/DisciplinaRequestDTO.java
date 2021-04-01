package br.com.zup.Squad.disciplina;

import br.com.zup.Squad.validation.UniqueValueValid;
import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class DisciplinaRequestDTO {

    @NotBlank
    @UniqueValueValid(field = "titulo", classe = Disciplina.class)
    private String titulo;
    @NotBlank
    @UniqueValueValid(field = "descricao", classe = Disciplina.class)
    private String descricao;
    @NotNull
    @Min(2)@Max(8)
    private Double cargaHoraria;

    public DisciplinaRequestDTO() {
    }

    public DisciplinaRequestDTO(@NotBlank String titulo, @NotBlank String descricao, @Min(2) @Max(8) Double cargaHoraria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public Disciplina converter() {
        return new Disciplina (this.titulo, this.descricao, this.cargaHoraria);

    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }
}
