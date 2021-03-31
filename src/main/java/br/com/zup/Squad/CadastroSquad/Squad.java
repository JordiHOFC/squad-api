package br.com.zup.Squad.CadastroSquad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Squad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String nome;
	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public Integer getQtd_membros() {
		return qtd_membros;
	}


	@Column(nullable = false)
	@Min(1)
	@Max(6)
	private Integer qtd_membros;

	public Squad(){
		
	}
	
	
	public Squad(String nome, @Min(1) @Max(6) int qtd_membros) {
		this.nome = nome;
		this.qtd_membros = qtd_membros;
	}

}
