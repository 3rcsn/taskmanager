package com.ercsn.taskmanager.application;

import com.ercsn.taskmanager.application.output.TaskOutput;
import com.ercsn.taskmanager.domain.TaskId;
import com.ercsn.taskmanager.domain.TaskNotFoundException;
import com.ercsn.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase (TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id) {
        return repository.findById(id).map(TaskOutput::from).orElseThrow(() -> new TaskNotFoundException(id));
    }
}
