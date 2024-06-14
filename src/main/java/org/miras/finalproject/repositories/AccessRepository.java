package org.miras.finalproject.repositories;

import org.miras.finalproject.models.Access;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRepository extends JpaRepository<Access, Long> {
    Access findByStudentLoginAndCourseId(String login, Long courseId);
}
