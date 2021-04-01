package br.com.zup.Squad.squad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Squad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String nome;

	@Column(nullable = false)
	@Min(1) @Max(6)
	private Integer quantidadeMembros;

	public Squad(String nome, @Min(1) @Max(6) int qtd_membros) {
		this.nome = nome;
		this.quantidadeMembros = qtd_membros;
	}
	public Squad(){	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
