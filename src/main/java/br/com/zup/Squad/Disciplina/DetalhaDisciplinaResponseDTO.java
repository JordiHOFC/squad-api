package br.com.zup.Squad.Disciplina;

public class DetalhaDisciplinaResponseDTO {

    private String titulo;
    private String descrição;
    private Double cargaHoraria;

    public DetalhaDisciplinaResponseDTO(Disciplina disciplina) {
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
