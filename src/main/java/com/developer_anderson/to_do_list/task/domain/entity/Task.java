package com.developer_anderson.to_do_list.task.domain.entity;

import com.developer_anderson.to_do_list.task.domain.enums.TaskStatus;
import com.developer_anderson.to_do_list.task.domain.valueobject.TaskId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tasks")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task {
    @EmbeddedId
    private TaskId id;

    @Column(name = "name",nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private TaskStatus status;

    @Column(name = "created_at",nullable = false)
    private Instant createdAt;

    private Task(String name) {
        this.id = TaskId.generate();
        this.name = name;
        this.status = TaskStatus.IN_PROGRESS;
        this.createdAt = Instant.now();
    }
    public static Task create(String name) {
        return new Task(name);
    }


}
