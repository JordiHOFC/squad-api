package br.com.zup.Squad.handler;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApiErro {
    private int code;
    private LocalDateTime timeStamp;
    private String message;
    List<Erros> listErros=new ArrayList<>();

    public ApiErro(List<Erros> listErros) {
        this.listErros = listErros;
        this.code= HttpStatus.BAD_REQUEST.value();
        this.message=HttpStatus.BAD_REQUEST.getReasonPhrase();
        this.timeStamp=LocalDateTime.now();
    }

    public int getCode() {
        return code;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public List<Erros> getListErros() {
        return listErros;
    }
}
