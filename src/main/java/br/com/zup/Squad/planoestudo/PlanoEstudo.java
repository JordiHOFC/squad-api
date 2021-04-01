package br.com.zup.Squad.planoestudo;

import br.com.zup.Squad.disciplina.Disciplina;
import br.com.zup.Squad.squad.Squad;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PlanoEstudo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(unique = true,nullable = false)
    private String descricao;

    @ManyToOne
    private Squad squad;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas=new ArrayList<>();

    public PlanoEstudo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public PlanoEstudo() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
