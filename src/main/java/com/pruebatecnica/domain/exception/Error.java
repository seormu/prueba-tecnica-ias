package com.pruebatecnica.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Error {
    private String mensaje;
    private int codigo;
}
