package org.miras.finalproject.repositories;

import org.miras.finalproject.models.Course;
import org.miras.finalproject.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c.tasks FROM Course c WHERE c.id = :courseId")
    Set<Task> findTasksByCourseId(Long courseId);
}
