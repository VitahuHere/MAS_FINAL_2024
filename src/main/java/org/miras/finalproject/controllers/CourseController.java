package org.miras.finalproject.controllers;

import org.miras.finalproject.DTOs.CourseDTO;
import org.miras.finalproject.DTOs.TaskDTO;
import org.miras.finalproject.services.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public List<CourseDTO> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDTO> getTasks(@PathVariable Long id) {
        return courseService.getCourseTasks(id);
    }
}
