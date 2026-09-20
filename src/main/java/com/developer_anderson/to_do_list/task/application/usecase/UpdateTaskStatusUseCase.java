package com.developer_anderson.to_do_list.task.application.usecase;

import com.developer_anderson.to_do_list.task.domain.entity.Task;
import com.developer_anderson.to_do_list.task.domain.enums.TaskStatus;
import com.developer_anderson.to_do_list.task.domain.repository.TaskRepository;
import com.developer_anderson.to_do_list.task.domain.valueobject.TaskId;
import com.developer_anderson.to_do_list.task.web.dto.response.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateTaskStatusUseCase {
    private final TaskRepository taskRepository;

    @Transactional
    public TaskResponse execute(UUID id, TaskStatus taskStatus) {
        Task task = taskRepository.findByid(TaskId.ofUUID(id));
        task.setStatus(taskStatus);
        Task updatedTask =  taskRepository.save(task);
        return TaskResponse.create(updatedTask);
    }
}
