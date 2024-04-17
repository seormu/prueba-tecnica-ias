package com.pruebatecnica.domain.usecase.task;

import com.pruebatecnica.domain.exception.BadRequestException;
import com.pruebatecnica.domain.model.task.Task;
import com.pruebatecnica.domain.model.task.gateway.TaskRepository;
import com.pruebatecnica.domain.model.user.gateway.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class TaskUseCase {

    private final TaskRepository repositoryTask;
    private final UserRepository repositoryUser;

    public Mono<Task> createTask(Task task){
        return task.validarAlCrear()
                .flatMap(isvalid ->
                        repositoryUser.existsById(task.getDuenio().toString())
                                .flatMap(exist -> {
                                    if (exist){
                                        return repositoryTask.createTask(task);
                                    }
                                    return Mono.error(new BadRequestException(String.format("El usuario con id %S no existe en la base de datos", task.getDuenio())));
                                }));
    }

    public Mono<Task> findByIdTask(String id){
        return repositoryTask.findById(id)
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new BadRequestException(String.format("No existe una tarea con el id %s", id)))));
    }

    public Mono<List<Task>> getTasks(PageRequest pageRequest) {
        repositoryTask.getTasks(pageRequest);
        return Mono.empty();
    }
}
