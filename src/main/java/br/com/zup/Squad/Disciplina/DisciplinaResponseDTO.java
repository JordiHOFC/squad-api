package br.com.zup.Squad.Disciplina;

import javax.persistence.Column;

public class DisciplinaResponseDTO {

    private Long Id;
    private String titulo;

    public DisciplinaResponseDTO(Disciplina entity) {
        this.Id = entity.getId();
        this.titulo = entity.getTitulo();
    }


    public Long getId() {
        return Id;
    }

    public String getTitulo() {
        return titulo;
    }
}
