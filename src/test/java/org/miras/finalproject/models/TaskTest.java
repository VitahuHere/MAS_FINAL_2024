package org.miras.finalproject.models;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.miras.finalproject.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TaskTest {
    @Autowired
    private TaskRepository taskRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private Task task;

    @Test
    void testCreateTask() {
        task = Task.builder()
                .title("Task 1")
                .content("Task 1 content")
                .build();
        taskRepository.save(task);
        entityManager.flush();

        Task found = taskRepository.findById(task.getId()).orElse(null);
        assertNotNull(found);
        assertEquals(task.getTitle(), found.getTitle());
        assertEquals(task.getContent(), found.getContent());
        assertEquals(TaskStatus.DRAFT, found.getStatus());
    }

    @Test
    void testSetAsPublished() {
        task = Task.builder()
                .title("Task 2")
                .content("Task 2 content")
                .build();
        taskRepository.save(task);
        entityManager.flush();

        task.setAsPublished();
        taskRepository.save(task);
        entityManager.flush();

        Task found = taskRepository.findById(task.getId()).orElse(null);
        assertNotNull(found);
        assertEquals(TaskStatus.PUBLISHED, found.getStatus());
    }

    @Test
    void testSetAsArchived() {
        task = Task.builder()
                .title("Task 3")
                .content("Task 3 content")
                .build();
        taskRepository.save(task);
        entityManager.flush();

        task.setAsArchived();
        taskRepository.save(task);
        entityManager.flush();

        Task found = taskRepository.findById(task.getId()).orElse(null);
        assertNotNull(found);
        assertEquals(TaskStatus.ARCHIVED, found.getStatus());
    }

    @Test
    void testSetAsDraft() {
        task = Task.builder()
                .title("Task 4")
                .content("Task 4 content")
                .build();
        taskRepository.save(task);
        entityManager.flush();

        task.setAsPublished();
        taskRepository.save(task);
        entityManager.flush();

        task = taskRepository.findById(task.getId()).orElse(null);
        assertNotNull(task);
        assertEquals(TaskStatus.PUBLISHED, task.getStatus());

        task.setAsDraft();
        taskRepository.save(task);
        entityManager.flush();

        Task found = taskRepository.findById(task.getId()).orElse(null);
        assertNotNull(found);
        assertEquals(TaskStatus.DRAFT, found.getStatus());
    }
}
