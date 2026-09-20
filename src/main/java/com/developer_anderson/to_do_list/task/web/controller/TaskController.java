package com.developer_anderson.to_do_list.task.web.controller;

import com.developer_anderson.to_do_list.task.application.usecase.CreateTaskUseCase;
import com.developer_anderson.to_do_list.task.web.dto.request.CreateTaskRequest;
import com.developer_anderson.to_do_list.task.web.dto.response.CreateTaskResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;
    @PostMapping
    public ResponseEntity<CreateTaskResponse> create(@RequestBody @Valid CreateTaskRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.createTaskUseCase.execute(request));
    }
}
