package com.pruebatecnica.application;

import com.pruebatecnica.domain.usecase.task.TaskUseCase;
import com.pruebatecnica.infrastructure.adapters.task.TaskDataAdapter;
import com.pruebatecnica.infrastructure.adapters.user.UserDataAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public TaskUseCase taskUseCase(TaskDataAdapter taskDataAdapter, UserDataAdapter userDataAdapter){
        return new TaskUseCase(taskDataAdapter, userDataAdapter);
    }
}
