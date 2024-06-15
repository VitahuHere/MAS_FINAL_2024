package org.miras.finalproject.services;

import org.miras.finalproject.DTOs.PostTaskDTO;
import org.miras.finalproject.models.Course;
import org.miras.finalproject.models.Task;
import org.miras.finalproject.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void saveTask(Course course, PostTaskDTO task) {
        Task newTask = Task.builder()
                .title(task.getTitle())
                .content(task.getContent())
                .status(task.getStatus())
                .courses(Set.of(course))
                .build();
        taskRepository.save(newTask);
    }
}
