package com.ercsn.taskmanager.infrastructure.http.request;

import com.ercsn.taskmanager.application.input.UpdateTaskInput;
import com.ercsn.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskRequest(
        Optional<String> title,
        Optional<String> description,
        Optional<String> status
) {
    public UpdateTaskInput toInput() {
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }
}
