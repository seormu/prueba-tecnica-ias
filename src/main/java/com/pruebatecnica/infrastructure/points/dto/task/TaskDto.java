package com.pruebatecnica.infrastructure.points.dto.task;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class TaskDto {
    private UUID id;
    private  String nombre;
    private  String descripcion;
    private  boolean estado;
    private  String fecha;
    private  UUID duenio;
}
