package com.pruebatecnica.domain.model.task;

import com.pruebatecnica.domain.exception.BadRequestException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class Task {
    private UUID id;
    private  String nombre;
    private  String descripcion;
    private  boolean estado;
    private  String fecha;
    private  UUID duenio;

    public Mono<Task> validarAlCrear(){
        return Mono.defer(() ->  validarNull("nombre", nombre))
                .switchIfEmpty(Mono.defer(this::obtenerFechaActual))
                .thenReturn(Task.this);
    }

    public Mono<Void> obtenerFechaActual(){
        fecha = LocalDate.now().toString();
        return Mono.empty();
    }

    public Mono<Void> validarNull(String campo, String valor){
        if (valor == null || valor.isEmpty()){
            return Mono.error(new BadRequestException(String.format("El campo %s no debe estar vacio", campo)));
        }
        return Mono.empty();
    }
}
