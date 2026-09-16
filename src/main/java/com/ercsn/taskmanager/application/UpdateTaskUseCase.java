package com.ercsn.taskmanager.application;

import com.ercsn.taskmanager.application.input.UpdateTaskInput;
import com.ercsn.taskmanager.application.output.TaskOutput;
import com.ercsn.taskmanager.domain.TaskId;
import com.ercsn.taskmanager.domain.TaskNotFoundException;
import com.ercsn.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute (TaskId id, UpdateTaskInput input) {
        var task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.update(input.title(), input.description(), input.status());
        var updated = repository.save(task);
        return TaskOutput.from(updated);
    }
}
