package org.miras.finalproject.services;

import org.miras.finalproject.DTOs.TaskDTO;
import org.miras.finalproject.models.Task;
import org.miras.finalproject.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


}
