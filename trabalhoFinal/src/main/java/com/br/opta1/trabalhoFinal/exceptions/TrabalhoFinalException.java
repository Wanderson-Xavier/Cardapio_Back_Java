package com.br.opta1.trabalhoFinal.exceptions;

import lombok.Getter;

@Getter
public class TrabalhoFinalException extends RuntimeException{
    private final String message;
    private String description;
    private final Integer statusCode;

    public TrabalhoFinalException(String message, Integer statusCode){
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }
    public TrabalhoFinalException(String message, String description, Integer statusCode){
        super(message);
        this.message = message;
        this.description = description;
        this.statusCode = statusCode;
    }
}
