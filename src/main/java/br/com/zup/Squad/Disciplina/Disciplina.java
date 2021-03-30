package br.com.zup.Squad.Disciplina;

import br.com.zup.Squad.validation.UniqueValueValid;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true , nullable = false)
    private String titulo;
    @NotBlank
    @Column(unique = true , nullable = false)
    private String descricao;
    @NotNull
    @Column(nullable = false)
    private Double cargaHoraria;


    public Disciplina() {
    }

    public Disciplina(String titulo, @NotBlank String descricao, @NotBlank Double cargaHoraria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId() {
        return Id;
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
