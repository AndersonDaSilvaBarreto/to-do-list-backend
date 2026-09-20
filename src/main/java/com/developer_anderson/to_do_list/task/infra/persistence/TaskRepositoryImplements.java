package com.developer_anderson.to_do_list.task.infra.persistence;

import com.developer_anderson.to_do_list.task.domain.entity.Task;
import com.developer_anderson.to_do_list.task.domain.enums.TaskStatus;
import com.developer_anderson.to_do_list.task.domain.repository.TaskRepository;
import com.developer_anderson.to_do_list.task.domain.valueobject.TaskId;
import com.developer_anderson.to_do_list.task.exception.TaskNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

    @Override
    public List<Task> findAll(UUID cursor, String name, TaskStatus status, int limit) {
        if(limit <=0) limit = 10;
        Specification<Task> specs =
                Specification.where(TaskSpecifications.idGraterThan(
                        cursor != null ? TaskId.ofUUID(cursor) : null))
                        .and(TaskSpecifications.byName(name))
                        .and(TaskSpecifications.byStatus(status));
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(0, limit, sort);
        return springDataTask.findAll(specs, pageable).getContent();
    }
}
