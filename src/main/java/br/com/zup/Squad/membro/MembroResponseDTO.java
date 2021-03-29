package br.com.zup.Squad.membro;

public class MembroResponseDTO {
    private Long id;
    private String nome;

    public MembroResponseDTO(Membro entity) {
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
