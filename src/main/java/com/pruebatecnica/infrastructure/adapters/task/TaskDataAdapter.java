package com.pruebatecnica.infrastructure.adapters.task;

import com.pruebatecnica.domain.model.task.Task;
import com.pruebatecnica.domain.model.task.gateway.TaskRepository;
import com.pruebatecnica.infrastructure.points.mappers.TaskMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class TaskDataAdapter implements TaskRepository {

    private final TaskDataRepository dataRepositoryTask;
    private final TaskMapper mapperTask;

    public TaskDataAdapter(TaskDataRepository dataRepositoryTask, TaskMapper mapperTask) {
        this.dataRepositoryTask = dataRepositoryTask;
        this.mapperTask = mapperTask;
    }

    @Override
    public Mono<Task> createTask(Task task) {
        return dataRepositoryTask.save(mapperTask.taskToTaskEtity(task))
                .map(mapperTask::taskEntiryToTask);
    }

    @Override
    public Mono<Task> findById(String id) {
        return dataRepositoryTask.findById(id)
                .map(mapperTask::taskEntiryToTask);
    }

    @Override
    public Mono<Page<Task>> getTasks(PageRequest pageRequest) {
        return null;
    }


}
