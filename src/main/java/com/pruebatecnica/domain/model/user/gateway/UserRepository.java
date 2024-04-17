package com.pruebatecnica.domain.model.user.gateway;

import com.pruebatecnica.domain.model.user.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<Boolean> existsById(String id);
}
