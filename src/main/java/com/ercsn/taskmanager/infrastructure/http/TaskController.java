package com.ercsn.taskmanager.infrastructure.http;

import com.ercsn.taskmanager.GetTaskByIdUseCase;
import com.ercsn.taskmanager.application.CreateTaskUseCase;
import com.ercsn.taskmanager.application.GetTaskUseCase;
import com.ercsn.taskmanager.infrastructure.http.request.CreateTaskRequest;
import com.ercsn.taskmanager.infrastructure.http.response.TaskResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;
    private GetTaskUseCase getTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase, GetTaskUseCase getTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTaskUseCase = getTaskUseCase;
    }

    @PostMapping
    TaskResponse create(@RequestBody CreateTaskRequest request) {
        var input = request.toInput();
        var output = createTaskUseCase.execute(input);
        return TaskResponse.from(output);
    }

    @GetMapping
    List<TaskResponse> list() {
        return getTaskUseCase.execute().stream().map(TaskResponse::from).toList();
    }

}
