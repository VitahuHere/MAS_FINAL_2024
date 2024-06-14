package org.miras.finalproject.repositories;

import org.miras.finalproject.models.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomUserRepository extends JpaRepository<CustomUser, String> {
    CustomUser findByLogin(String login);
}
