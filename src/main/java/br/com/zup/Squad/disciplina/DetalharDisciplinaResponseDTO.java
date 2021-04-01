package br.com.zup.Squad.disciplina;

public class DetalharDisciplinaResponseDTO {

    private String titulo;
    private String descrição;
    private Double cargaHoraria;

    public DetalharDisciplinaResponseDTO(Disciplina disciplina) {
        this.titulo = disciplina.getTitulo();
        this.descrição = disciplina.getDescricao();
        this.cargaHoraria = disciplina.getCargaHoraria();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescrição() {
        return descrição;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }
}
