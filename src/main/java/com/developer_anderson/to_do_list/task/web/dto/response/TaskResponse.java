package com.developer_anderson.to_do_list.task.web.dto.response;

import com.developer_anderson.to_do_list.task.domain.entity.Task;
import com.developer_anderson.to_do_list.task.domain.enums.TaskStatus;
import java.time.Instant;
import java.util.UUID;

public record TaskResponse(
        UUID id,
        String name,
        TaskStatus status,
        Instant createdAt
) {
    public static TaskResponse create(Task task) {
        return new TaskResponse(
                task.getId().getValue(),
                task.getName(),
                task.getStatus(),
                task.getCreatedAt());
    }
}
