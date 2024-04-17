package com.pruebatecnica.infrastructure.points.mappers;

import com.pruebatecnica.domain.model.task.Task;
import com.pruebatecnica.infrastructure.adapters.task.TaskEntity;
import com.pruebatecnica.infrastructure.points.dto.task.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task taskDtoToTask(TaskDto taskDto);
    TaskEntity taskToTaskEtity(Task task);
    Task taskEntiryToTask(TaskEntity task);
}
