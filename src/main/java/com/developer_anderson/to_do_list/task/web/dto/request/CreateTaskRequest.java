package com.developer_anderson.to_do_list.task.web.dto.request;

import org.hibernate.validator.constraints.Length;

public record CreateTaskRequest(
        @Length(min = 2, max = 100, message = "Name must have between 2 and 100 characters")
        String name
) {
}
