package br.com.zup.Squad.squad;

public class SquadResponse {
	private Long id;
	private String nome;
	
	
	public SquadResponse(Squad entity) {
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
