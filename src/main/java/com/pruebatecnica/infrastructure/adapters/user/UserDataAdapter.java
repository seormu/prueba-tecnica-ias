package com.pruebatecnica.infrastructure.adapters.user;

import com.pruebatecnica.domain.model.user.gateway.UserRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class UserDataAdapter implements UserRepository {

    private final UserDataRepository repositoryUserData;

    public UserDataAdapter(UserDataRepository repositoryUserData) {
        this.repositoryUserData = repositoryUserData;
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return repositoryUserData.existsById(id);
    }
}
