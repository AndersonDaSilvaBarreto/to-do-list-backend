package com.developer_anderson.to_do_list.task.web.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Builder
public record ErrorResponse(
        String type,
        String title,
        int status,
        String instance,
        Instant timestamp
) {
    public static ErrorResponse of(String title, HttpStatus status, String instance) {
        return ErrorResponse.builder()
                .type("localhost:3000/errors" + status.name().toLowerCase())
                .title(title)
                .status(status.value())
                .instance(instance)
                .timestamp(Instant.now())
                .build();
    }
}
