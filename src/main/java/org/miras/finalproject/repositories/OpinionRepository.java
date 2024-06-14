package org.miras.finalproject.repositories;

import org.miras.finalproject.models.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
