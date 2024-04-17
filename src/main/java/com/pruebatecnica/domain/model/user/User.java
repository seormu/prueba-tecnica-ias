package com.pruebatecnica.domain.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class User {
    private UUID id;
    private String nombre;
}
