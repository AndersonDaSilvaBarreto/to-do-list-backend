package com.developer_anderson.to_do_list.task.domain.repository;

import com.developer_anderson.to_do_list.task.domain.entity.Task;
import com.developer_anderson.to_do_list.task.domain.enums.TaskStatus;
import com.developer_anderson.to_do_list.task.domain.valueobject.TaskId;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {
    Task save(Task task);
    Task findByid(TaskId id);
    List<Task> findAll(UUID cursor, String name, TaskStatus status, int limit);
    Task deleteById(TaskId id);
}
