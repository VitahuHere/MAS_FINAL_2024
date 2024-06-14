package org.miras.finalproject.repositories;

import org.miras.finalproject.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
