package br.com.zup.Squad.CadastroSquad;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import br.com.zup.Squad.validation.UniqueValueValid;

public class SqadRequest {
	@NotBlank
	@UniqueValueValid(classe = Squad.class, field = "nome")
	private String nome;

	@Min(1)
	@Max(6)
	private Integer qtd_membros;

	public String getNome() {
		return nome;
	}

	public Integer getQtd_membros() {
		return qtd_membros;
	}

	public SqadRequest(String nome, Integer qtd_membros) {
		this.nome = nome;
		this.qtd_membros = qtd_membros;

	}

	public  Squad convertToEntity() {
	
		return new Squad(this.nome, this.qtd_membros);
	}

}
