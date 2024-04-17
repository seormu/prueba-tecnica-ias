package com.pruebatecnica.infrastructure.adapters.task;

import com.pruebatecnica.infrastructure.adapters.user.UserEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@Table(name = "task")
@RequiredArgsConstructor
public class TaskEntity {
    @Id
    private UUID id;
    @Column
    private  String nombre;
    @Column
    private  String descripcion;
    @Column
    private  boolean estado;
    @Column
    private  String fecha;
    @Column
    private UUID duenio;
}
