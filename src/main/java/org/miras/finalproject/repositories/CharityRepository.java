package org.miras.finalproject.repositories;

import org.miras.finalproject.models.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharityRepository extends JpaRepository<Charity, String> {
}
