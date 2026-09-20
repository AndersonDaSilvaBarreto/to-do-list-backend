package com.developer_anderson.to_do_list.task.infra.persistence;


import com.developer_anderson.to_do_list.task.domain.entity.Task;
import com.developer_anderson.to_do_list.task.domain.entity.Task_;
import com.developer_anderson.to_do_list.task.domain.enums.TaskStatus;
import com.developer_anderson.to_do_list.task.domain.valueobject.TaskId;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecifications {
    public static Specification<Task> idGraterThan(TaskId id) {
        return (root, criteriaQuery, cb) -> {
            if(id == null) {
                return cb.conjunction();
            }
            return cb.greaterThan(root.get(Task_.id), id);
        };

    }
    public static Specification<Task> byName(String name) {
        return (root, criteriaQuery, cb) -> {
            if(name == null || name.trim().isBlank()) {
                return cb.conjunction();
            }
            String term = "%" + name.trim().toLowerCase() + "%";
            return cb.like(cb.lower(root.get(Task_.name)),term);
        };
    }
    public static Specification<Task> byStatus(TaskStatus status) {
        return (root, query, cb) ->  {
            if(status == null) {
                return  cb.conjunction();
            }
            return cb.equal(root.get(Task_.status),status);
        };
    }

}
