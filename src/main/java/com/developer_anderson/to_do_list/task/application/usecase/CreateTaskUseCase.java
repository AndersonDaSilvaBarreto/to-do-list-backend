package com.developer_anderson.to_do_list.task.application.usecase;

import com.developer_anderson.to_do_list.task.domain.entity.Task;
import com.developer_anderson.to_do_list.task.domain.repository.TaskRepository;
import com.developer_anderson.to_do_list.task.web.dto.request.CreateTaskRequest;
import com.developer_anderson.to_do_list.task.web.dto.response.CreateTaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateTaskUseCase {
    private final TaskRepository taskRepository;

    @Transactional
    public CreateTaskResponse execute(CreateTaskRequest request) {
        Task task = Task.create(request.name());
        Task createdTask = taskRepository.save(task);
        return  CreateTaskResponse.create(createdTask);
    }

}
