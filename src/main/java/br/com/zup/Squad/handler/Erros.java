package br.com.zup.Squad.handler;

import org.springframework.validation.FieldError;

public class Erros {
    private String campo;
    private String message;

    public Erros(FieldError error) {
        this.campo = error.getField();
        this.message = error.getDefaultMessage();
    }

    public String getCampo() {
        return campo;
    }

    public String getMessage() {
        return message;
    }

}
