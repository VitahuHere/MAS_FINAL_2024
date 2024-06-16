package org.miras.finalproject.services;

import org.miras.finalproject.DTOs.CourseDTO;
import org.miras.finalproject.DTOs.CourseDetailsDTO;
import org.miras.finalproject.DTOs.GetTaskDTO;
import org.miras.finalproject.models.Access;
import org.miras.finalproject.models.Course;
import org.miras.finalproject.models.Task;
import org.miras.finalproject.repositories.AccessRepository;
import org.miras.finalproject.repositories.CourseRepository;
import org.miras.finalproject.repositories.CustomUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CustomUserRepository customUserRepository;
    private final AccessRepository accessRepository;

    public CourseService(CourseRepository courseRepository, CustomUserRepository customUserRepository, AccessRepository accessRepository) {
        this.courseRepository = courseRepository;
        this.customUserRepository = customUserRepository;
        this.accessRepository = accessRepository;
    }

    public List<CourseDTO> getCourses() {
        return courseRepository.findAll().stream().map(CourseDTO::new).toList();
    }

    public List<GetTaskDTO> getCourseTasks(Long id) {
        Set<Task> tasks = courseRepository.findTasksByCourseId(id);
        return tasks.stream().map(GetTaskDTO::new).collect(Collectors.toList());
    }

    public CourseDetailsDTO getCourseDetails(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            return null;
        }
        return new CourseDetailsDTO(course);
    }

    public Course findCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addStudentToCourse(Long courseId, String login) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            return;
        }
        Access access = Access.builder().student(customUserRepository.findByLogin(login)).course(course).build();
        accessRepository.save(access);
    }

    public void removeStudentFromCourse(Long courseId, String login) {
        Access access = accessRepository.findByStudentLoginAndCourseId(login, courseId);
        if (access == null) {
            return;
        }
        accessRepository.delete(access);
    }
}
