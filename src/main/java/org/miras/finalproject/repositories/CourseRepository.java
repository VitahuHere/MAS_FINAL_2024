package org.miras.finalproject.repositories;

import org.miras.finalproject.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
