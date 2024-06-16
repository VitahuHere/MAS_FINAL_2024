package org.miras.finalproject.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.miras.finalproject.repositories.AccessRepository;
import org.miras.finalproject.repositories.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class OpinionTest {
    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private AccessRepository accessRepository;

    @PersistenceContext
    private EntityManager manager;

    @Test
    void testCreateOpinion(){
        Access access = accessRepository.findById(10001L).orElse(null);
        Opinion opinion = Opinion.builder()
                .score(5)
                .comment("Great course")
                .student(access.getStudent())
                .course(access.getCourse())
                .build();

        opinionRepository.save(opinion);
        manager.flush();
        assertEquals(1, List.of(opinionRepository.findAll()).size());
    }
}
