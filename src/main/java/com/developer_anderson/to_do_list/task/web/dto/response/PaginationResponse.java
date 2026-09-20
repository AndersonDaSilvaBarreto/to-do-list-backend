package com.developer_anderson.to_do_list.task.web.dto.response;

import java.util.List;
import java.util.UUID;

public record PaginationResponse<T>(
        List<T> content,
        boolean hasNext,
        UUID nextCursor
) {
}
