package com.developer_anderson.to_do_list.task.application.usecase;

import com.developer_anderson.to_do_list.task.domain.entity.Task;
import com.developer_anderson.to_do_list.task.domain.enums.TaskStatus;
import com.developer_anderson.to_do_list.task.domain.repository.TaskRepository;
import com.developer_anderson.to_do_list.task.web.dto.response.PaginationResponse;
import com.developer_anderson.to_do_list.task.web.dto.response.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaginationTaskUseCase {
    private final TaskRepository taskRepository;
    @Transactional(readOnly = true)
    public PaginationResponse<TaskResponse> execute(UUID cursor, String name, TaskStatus status, int limit) {
        if(limit <=0) limit = 10;
        List<Task> tasks = taskRepository.findAll(cursor,name,status,limit + 1);
        boolean hasNext = tasks.size() > limit;
        List<TaskResponse> taskResponses = tasks.stream()
                .limit(limit)
                .map(TaskResponse::create)
                .toList();
        return new PaginationResponse<>(
                taskResponses,
                hasNext,
                hasNext? taskResponses.getLast().id() : null
        );

    }
}
