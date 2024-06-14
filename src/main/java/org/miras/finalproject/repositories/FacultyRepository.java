package org.miras.finalproject.repositories;

import org.miras.finalproject.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
