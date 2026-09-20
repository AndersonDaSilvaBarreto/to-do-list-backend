package com.developer_anderson.to_do_list.task.infra.persistence;

import com.developer_anderson.to_do_list.task.domain.entity.Task;
import com.developer_anderson.to_do_list.task.domain.valueobject.TaskId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpringDataTask extends JpaRepository<Task, TaskId>, JpaSpecificationExecutor<Task> {
}
