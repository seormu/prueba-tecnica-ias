package com.pruebatecnica.domain.model.task.gateway;

import com.pruebatecnica.domain.model.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import reactor.core.publisher.Mono;

public interface TaskRepository {

    Mono<Task> createTask(Task task);

    Mono<Task> findById(String id);

    Mono<Page<Task>> getTasks(PageRequest pageRequest);
}
