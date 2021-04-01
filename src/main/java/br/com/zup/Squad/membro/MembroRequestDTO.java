package br.com.zup.Squad.membro;

import br.com.zup.Squad.validation.MaiorIdadeValid;
import br.com.zup.Squad.validation.UniqueValueValid;
import br.com.zup.Squad.validation.ValidEmail;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class MembroRequestDTO {

    @JsonProperty("nome")
    @NotBlank
    private String nome;
    @UniqueValueValid(field = "email", classe = Membro.class)
    @JsonProperty("email")
    @NotBlank
    @Email
    @ValidEmail
    private String email;
    @JsonProperty("senha")
    @NotBlank
    private String senha;
    @JsonProperty("dataNascimento")
    @MaiorIdadeValid
    private LocalDate dataNascimento;

    public MembroRequestDTO() {
    }

    public MembroRequestDTO(String nome, String email, String senha, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public Membro converter(){
        return new Membro(this.nome,this.email,this.senha,this.dataNascimento);
    }
}
