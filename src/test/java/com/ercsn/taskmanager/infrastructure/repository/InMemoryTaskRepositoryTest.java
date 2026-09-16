package com.ercsn.taskmanager.infrastructure.repository;

import com.ercsn.taskmanager.domain.*;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {
    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }

}