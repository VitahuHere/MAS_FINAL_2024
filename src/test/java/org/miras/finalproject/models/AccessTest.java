package org.miras.finalproject.models;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.miras.finalproject.repositories.AccessRepository;
import org.miras.finalproject.repositories.CourseRepository;
import org.miras.finalproject.repositories.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AccessTest {
    @Autowired
    private AccessRepository accessRepository;

    @Autowired
    private CustomUserRepository customUserRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void testGetters() {
        Access access = accessRepository.findById(10001L).orElse(null);
        CustomUser student = customUserRepository.findByLogin("student");
        Course course = courseRepository.findById(10001L).orElse(null);

        assertNotNull(access);
        assertEquals("2024-01-01", access.getPurchaseDate().toString());
        assertEquals(student, access.getStudent());
        assertEquals(course, access.getCourse());
    }

    @Test
    void testBag(){
        CustomUser student = customUserRepository.findByLogin("student");
        Course course = courseRepository.findById(10001L).orElse(null);
        Access access = Access.builder()
                .purchaseDate(LocalDate.of(2024, 1, 1))
                .student(student)
                .course(course)
                .build();
        accessRepository.save(access);
        entityManager.flush();
        access = Access.builder()
                .purchaseDate(LocalDate.of(2024, 1, 1))
                .student(student)
                .course(course)
                .build();
        accessRepository.save(access);
        entityManager.flush();
        entityManager.refresh(student);
        assertEquals(3, student.getAccesses().size());
    }
}
