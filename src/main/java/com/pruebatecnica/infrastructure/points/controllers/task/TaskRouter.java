package com.pruebatecnica.infrastructure.points.controllers.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TaskRouter {

    @Bean
    public RouterFunction<ServerResponse> route(TaskHandler handler){
        return RouterFunctions.route()
                .POST("/task", handler::createTask)
                .GET("/task/{id}", handler::getById)
                .GET("tasks/{page}/{size}", handler::getTasks)
                .build();
    }
}
