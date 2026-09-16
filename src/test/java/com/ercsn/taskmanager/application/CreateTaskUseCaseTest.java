package com.ercsn.taskmanager.application;

import com.ercsn.taskmanager.application.input.CreateTaskInput;
import com.ercsn.taskmanager.application.output.TaskOutput;
import com.ercsn.taskmanager.domain.Task;
import com.ercsn.taskmanager.domain.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CreateTaskUseCaseTest {

    @Mock
    TaskRepository repository;

    @InjectMocks
    CreateTaskUseCase useCase;

    @Test
    void shouldCreateTaskSuccessfully() {
        var input = new CreateTaskInput("Estudar Java", Optional.of("Finalizar o módulo de Records"));

        when(repository.save(any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        TaskOutput output = useCase.execute(input);

        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals("Estudar Java", output.title());
        assertEquals(Optional.of("Finalizar o módulo de Records"), output.description());

        verify(repository, times(1)).save(any(Task.class));
    }
}