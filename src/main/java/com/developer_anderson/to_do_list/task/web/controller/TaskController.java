package com.developer_anderson.to_do_list.task.web.controller;

import com.developer_anderson.to_do_list.task.application.usecase.CreateTaskUseCase;
import com.developer_anderson.to_do_list.task.application.usecase.DeleteTaskUseCase;
import com.developer_anderson.to_do_list.task.application.usecase.PaginationTaskUseCase;
import com.developer_anderson.to_do_list.task.application.usecase.UpdateTaskStatusUseCase;
import com.developer_anderson.to_do_list.task.domain.enums.TaskStatus;
import com.developer_anderson.to_do_list.task.web.dto.request.CreateTaskRequest;
import com.developer_anderson.to_do_list.task.web.dto.request.UpdateStatusRequest;
import com.developer_anderson.to_do_list.task.web.dto.response.PaginationResponse;
import com.developer_anderson.to_do_list.task.web.dto.response.TaskResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;
    private final PaginationTaskUseCase paginationTaskUseCase;
    private final UpdateTaskStatusUseCase updateTaskStatusUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody @Valid CreateTaskRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.createTaskUseCase.execute(request));
    }

    @GetMapping
    public ResponseEntity<PaginationResponse<TaskResponse>> findAll(
            @RequestParam(required = false) UUID cursor,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) TaskStatus status,
            @RequestParam(required = false, defaultValue = "10") int limit) {
        var response = paginationTaskUseCase.execute(cursor, name, status, limit);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponse> updatedTaskStatus(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateStatusRequest request
    ) {
        var response = updateTaskStatusUseCase.execute(id, request.status());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TaskResponse> delete(@PathVariable UUID id) {
        var response = deleteTaskUseCase.execute(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

}
