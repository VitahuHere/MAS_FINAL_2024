package org.miras.finalproject.repositories;

import org.miras.finalproject.models.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
}
