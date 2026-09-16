package com.ercsn.taskmanager.application;

import com.ercsn.taskmanager.domain.TaskId;
import com.ercsn.taskmanager.domain.TaskNotFoundException;
import com.ercsn.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskUseCase {
    private final TaskRepository repository;

    public DeleteTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public void execute(TaskId taskId) {
        if (repository.findById(taskId).isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }

        repository.delete(taskId);
    }
}
