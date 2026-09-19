package com.developer_anderson.to_do_list.task.domain.valueobject;

import com.github.f4b6a3.uuid.UuidCreator;

import java.util.Objects;
import java.util.UUID;

public class TaskId {
    private UUID id;
    private TaskId(UUID id) {
        this.id = Objects.requireNonNull(id);
    }
    public TaskId generate() {
        return new TaskId(UuidCreator.getTimeOrderedEpoch());
    }
}
