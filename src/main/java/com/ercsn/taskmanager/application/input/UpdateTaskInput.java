package com.ercsn.taskmanager.application.input;

import com.ercsn.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskInput (Optional<String> title,
                               Optional<String> description,
                               Optional<TaskStatus> status) {
}
