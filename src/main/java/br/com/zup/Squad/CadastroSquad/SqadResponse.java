package br.com.zup.Squad.CadastroSquad;

public class SqadResponse {
	private Long id;
	private String nome;
	
	
	public SqadResponse(Squad entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

}
