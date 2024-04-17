package com.pruebatecnica.infrastructure.adapters.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@Table(name = "users")
@RequiredArgsConstructor
public class UserEntity {
    @Id
    private UUID id;
    @Column
    private String nombre;
}
