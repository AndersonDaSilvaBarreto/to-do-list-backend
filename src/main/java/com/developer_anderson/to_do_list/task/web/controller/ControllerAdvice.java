package com.developer_anderson.to_do_list.task.web.controller;

import com.developer_anderson.to_do_list.task.exception.TaskNotFoundException;
import com.developer_anderson.to_do_list.task.web.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAdvice {
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(
        TaskNotFoundException ex,
        HttpServletRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.of(ex.getMessage(), HttpStatus.NOT_FOUND, request.getRequestURI()));
    }
}
