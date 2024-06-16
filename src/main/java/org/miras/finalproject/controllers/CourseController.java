package org.miras.finalproject.controllers;

import org.miras.finalproject.DTOs.CourseDTO;
import org.miras.finalproject.DTOs.CourseDetailsDTO;
import org.miras.finalproject.DTOs.GetTaskDTO;
import org.miras.finalproject.DTOs.PostTaskDTO;
import org.miras.finalproject.models.Course;
import org.miras.finalproject.services.CourseService;
import org.miras.finalproject.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = {"*"})
public class CourseController {
    private final CourseService courseService;
    private final TaskService taskService;

    public CourseController(CourseService courseService, TaskService taskService) {
        this.courseService = courseService;
        this.taskService = taskService;
    }

    @GetMapping("")
    public List<CourseDTO> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public CourseDetailsDTO getCourse(@PathVariable Long id) {
        return courseService.getCourseDetails(id);
    }

    @GetMapping("/{id}/tasks")
    public List<GetTaskDTO> getTasks(@PathVariable Long id) {
        return courseService.getCourseTasks(id);
    }

    @PostMapping(value = "/{id}/tasks/add", consumes = {"*/*"})
    public ResponseEntity<String> addTask(@PathVariable Long id, @RequestBody PostTaskDTO task) {
        Course course = courseService.findCourseById(id);
        if (course == null) {
            return ResponseEntity.badRequest().body("Course not found");
        }
        taskService.saveTask(course, task);
        return ResponseEntity.noContent().build();
    }
}
