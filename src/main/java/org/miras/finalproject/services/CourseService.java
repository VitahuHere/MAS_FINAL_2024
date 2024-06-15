package org.miras.finalproject.services;

import org.miras.finalproject.DTOs.CourseDTO;
import org.miras.finalproject.DTOs.TaskDTO;
import org.miras.finalproject.models.Task;
import org.miras.finalproject.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final TaskService taskService;

    public CourseService(CourseRepository courseRepository, TaskService taskService) {
        this.courseRepository = courseRepository;
        this.taskService = taskService;
    }

    public List<CourseDTO> getCourses() {
        return courseRepository.findAll().stream().map(CourseDTO::new).toList();
    }

    public List<TaskDTO> getCourseTasks(Long id) {
        Set<Task> tasks = courseRepository.findTasksByCourseId(id);
        return tasks.stream().map(TaskDTO::new).collect(Collectors.toList());
    }
}
