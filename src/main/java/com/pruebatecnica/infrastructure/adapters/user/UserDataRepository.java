package com.pruebatecnica.infrastructure.adapters.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserDataRepository extends ReactiveCrudRepository<UserEntity, String> {
}
