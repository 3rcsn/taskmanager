package com.ercsn.taskmanager.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class TaskRepositoryTest {
    TaskRepository repository;

    protected abstract TaskRepository createRepository();

    @BeforeEach
    public void setUp() {
        this.repository = createRepository();
    }

    @Test
    void shouldSaveAndRetrieveTaskById() {
        var task = new Task("Passar na padoka", Optional.empty());

        var saved = repository.save(task);

        Optional<Task> result = repository.findById(saved.getId());

        assertThat(result.isPresent());
        assertThat(result.get().getId()).isEqualTo(task.getId());
        assertThat(result.get().getDescription()).isEqualTo(task.getDescription());
        assertThat(result.get().getStatus()).isEqualTo(task.getStatus());
    }

    @Test
    void shouldFindAllPersistedTasks() {
        var task1 = new Task("Arrumar chuveiro", Optional.of("Comprar chuveiro novo"));
        var task2 = new Task("Trocar interruptor", Optional.of("Encontrar chave de fenda"));

        repository.save(task1);
        repository.save(task2);
        List<Task> tasks = repository.findAll();

        assertThat(tasks).hasSize(2);
        assertThat(tasks).extracting(Task::getId).containsExactlyInAnyOrder(task1.getId(), task2.getId());
    }

    @Test
    void shouldDeleteTaskById() {
        var task = repository.save(new Task("Treinar na academia", Optional.empty()));
        var taskId = task.getId();

        repository.delete(taskId);
        Optional<Task> result = repository.findById(taskId);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldReturnEmptyWhenSearchingNonExistentTask() {
        var nonExistentId = new TaskId();

        Optional<Task> result = repository.findById(nonExistentId);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldUpdateTaskStatusSuccessfully() {
        var task = repository.save(new Task("Atualizar CNH", Optional.empty()));
        task.setDescription(Optional.of("Não expirou ainda"));
        task.setStatus(TaskStatus.IN_PROGRESS);

        repository.save(task);
        Optional<Task> result = repository.findById(task.getId());

        assertThat(result).isPresent();
        assertThat(result.get().getDescription()).isEqualTo(Optional.of("Não expirou ainda"));
        assertThat(result.get().getStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
    }
}