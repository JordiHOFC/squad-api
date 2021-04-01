package br.com.zup.Squad.squad;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.Squad.validation.UniqueValueValid;

public class SquadRequest {
	@NotBlank
	@UniqueValueValid(classe = Squad.class, field = "nome")
	private String nome;

	@Min(1) @Max(6)
	@NotNull
	private Integer quantiadeMembros;


	public SquadRequest(String nome, Integer quantiadeMembros) {
		this.nome = nome;
		this.quantiadeMembros = quantiadeMembros;

	}

	public  Squad converter() {
		return new Squad(this.nome, this.quantiadeMembros);
	}

	public String getNome() {
		return nome;
	}

	public Integer getQuantiadeMembros() {
		return quantiadeMembros;
	}
}
