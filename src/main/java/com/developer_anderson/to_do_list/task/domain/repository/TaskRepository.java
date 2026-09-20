package com.developer_anderson.to_do_list.task.domain.repository;

import com.developer_anderson.to_do_list.task.domain.entity.Task;
import com.developer_anderson.to_do_list.task.domain.valueobject.TaskId;

public interface TaskRepository {
    Task save(Task task);
    Task findByid(TaskId id);
}
