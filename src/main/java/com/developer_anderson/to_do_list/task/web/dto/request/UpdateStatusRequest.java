package com.developer_anderson.to_do_list.task.web.dto.request;

import com.developer_anderson.to_do_list.task.domain.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateStatusRequest(
        @NotNull
        TaskStatus status
) {
}
