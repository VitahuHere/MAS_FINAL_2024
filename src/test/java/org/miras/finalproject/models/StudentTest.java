package org.miras.finalproject.models;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.miras.finalproject.repositories.AccessRepository;
import org.miras.finalproject.repositories.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class StudentTest {
    private CustomUser student;

    @Autowired
    EntityManager entityManager;

    @Autowired
    private AccessRepository accessRepository;
    @Autowired
    private CustomUserRepository customUserRepository;

    @BeforeEach
    void setUp() {
        student = CustomUser.builder()
                .login("login")
                .name("name")
                .surname("surname")
                .privateEmail("email@gmail.com")
                .summary("summary")
                .birthDate(LocalDate.of(2000, 1, 1))
                .password("password")
                .roles(EnumSet.of(UserRole.STUDENT))
                .build();
    }

    @Test
    void testGetWorkEmail() {
        assertEquals("login@edu.quack.pl", student.getWorkEmail());
    }

    @Test
    void getters() {
        assertEquals("login", student.getLogin());
        assertEquals("name", student.getName());
        assertEquals("surname", student.getSurname());
        assertEquals("email@gmail.com", student.getPrivateEmail());
        assertEquals("summary", student.getSummary());
        assertEquals(LocalDate.of(2000, 1, 1), student.getBirthDate());
        assertEquals("password", student.getPassword());
    }

    @Test
    void testGetAccess() {
        student = customUserRepository.findByLogin("student");
        assertEquals(1, student.getAccesses().size());

        Access access = student.getAccesses().get(0);
        assertEquals("student", access.getStudent().getLogin());

        Course course = access.getCourse();
        access = Access.builder()
                .student(student)
                .course(course)
                .build();
        accessRepository.save(access);
        entityManager.flush();
        entityManager.refresh(student);
        assertEquals(2, student.getAccesses().size());
    }
}
