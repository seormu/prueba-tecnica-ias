package com.pruebatecnica.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Error> badRequestException(BadRequestException ex){
        Error error = new Error();
        error.setCodigo(404);
        error.setMensaje(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
