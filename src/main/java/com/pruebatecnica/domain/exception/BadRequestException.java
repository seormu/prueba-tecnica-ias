package com.pruebatecnica.domain.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String mensaje){
        super(mensaje);
    }
}
