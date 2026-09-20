package com.developer_anderson.to_do_list.task.domain.valueobject;

import com.github.f4b6a3.uuid.UuidCreator;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TaskId {
    private UUID value;

    private TaskId(UUID id) {
        this.value = Objects.requireNonNull(id);
    }

    public static TaskId generate() {
        return new TaskId(UuidCreator.getTimeOrderedEpoch());
    }

    public static TaskId ofUUID(UUID id) {
        return new TaskId(id);
    }

    @Override
    public String toString() {
        return getValue().toString();
    }
}
