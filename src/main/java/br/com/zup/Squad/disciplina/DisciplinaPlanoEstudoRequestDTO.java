package br.com.zup.Squad.disciplina;

import br.com.zup.Squad.validation.ExistIdValid;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DisciplinaPlanoEstudoRequestDTO {

    @JsonProperty("id")
    @ExistIdValid(domainClass=Disciplina.class)
    private Long id;

    public Disciplina converter(){
        return new Disciplina(this.id);
    }

}
