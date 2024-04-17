package com.pruebatecnica.infrastructure.points.controllers.task;

import com.pruebatecnica.domain.usecase.task.TaskUseCase;
import com.pruebatecnica.infrastructure.points.dto.task.TaskDto;
import com.pruebatecnica.infrastructure.points.mappers.TaskMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TaskHandler {

    private final TaskMapper mapperTask;
    private final TaskUseCase useCaseTask;

    public TaskHandler(TaskMapper mapperTask, TaskUseCase useCaseTask) {
        this.mapperTask = mapperTask;
        this.useCaseTask = useCaseTask;
    }

    public Mono<ServerResponse> createTask(ServerRequest request){
        return request.bodyToMono(TaskDto.class)
                .map(mapperTask::taskDtoToTask)
                .flatMap(useCaseTask::createTask)
                .flatMap(response ->
                        ServerResponse.
                                ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response));
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        System.out.printf("UU "+id);
        return useCaseTask.findByIdTask(id)
                .flatMap(response ->
                        ServerResponse
                                .ok()
                                .bodyValue(response)
                );
    }

    public Mono<ServerResponse> getTasks(ServerRequest request){
        int page = Integer.parseInt(request.pathVariable("page"));
        int size = Integer.parseInt(request.pathVariable("size"));
        PageRequest pageRequest = PageRequest.of(page, size);
        return useCaseTask.getTasks(pageRequest)
                .flatMap(list ->
                        ServerResponse
                                .ok()
                                .bodyValue(list));
    }
}
