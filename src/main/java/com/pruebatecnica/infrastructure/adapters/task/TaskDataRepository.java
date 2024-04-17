package com.pruebatecnica.infrastructure.adapters.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TaskDataRepository extends ReactiveCrudRepository<TaskEntity, String> {

}
