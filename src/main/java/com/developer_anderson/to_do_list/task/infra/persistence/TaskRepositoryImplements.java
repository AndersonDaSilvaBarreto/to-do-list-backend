package com.developer_anderson.to_do_list.task.infra.persistence;

import com.developer_anderson.to_do_list.task.domain.entity.Task;
import com.developer_anderson.to_do_list.task.domain.repository.TaskRepository;
import com.developer_anderson.to_do_list.task.domain.valueobject.TaskId;
import com.developer_anderson.to_do_list.task.exception.TaskNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImplements implements TaskRepository {
    private final SpringDataTask springDataTask;

    @Override
    public Task save(Task task) {
        return springDataTask.save(Objects.requireNonNull(task));
    }

    @Override
    public Task findByid(TaskId id) {
        return springDataTask.findById(Objects.requireNonNull(id)).orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " not founded"));
    }
}
