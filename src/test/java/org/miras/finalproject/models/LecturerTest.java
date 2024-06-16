package org.miras.finalproject.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.miras.finalproject.repositories.CourseRepository;
import org.miras.finalproject.repositories.CustomUserRepository;
import org.miras.finalproject.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class LecturerTest {
    private CustomUser user;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private CustomUserRepository customUserRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        user = CustomUser.builder()
                .login("login")
                .name("name")
                .surname("surname")
                .privateEmail("email@gmail.com")
                .summary("summary")
                .birthDate(LocalDate.of(2000, 1, 1))
                .password("password")
                .bankNumber("PL12345678901234567890123456")
                .salary(new BigDecimal("1000.00"))
                .roles(EnumSet.of(UserRole.LECTURER))
                .build();
    }

    @Test
    void testGetter() {
        assertEquals("PL12345678901234567890123456", user.getBankNumber());
        assertEquals(new BigDecimal("1000.00"), user.getSalary());
    }

    @Test
    void testXOR() {
        Faculty faculty = new Faculty();
        facultyRepository.save(faculty);

        user.setFaculty(faculty);
        customUserRepository.save(user);

        assertThrows(IllegalArgumentException.class, () -> {
            user.setCharity(new Charity());
            customUserRepository.save(user);
        });
    }

    @Test
    void testGetCourses() {
        user = customUserRepository.findByLogin("lecturer");
        assertEquals(3, user.getCourses().size());

        Course course = Course.builder()
                .name("course")
                .description("description")
                .keywords(List.of("keyword"))
                .createdAt(LocalDate.now())
                .lecturer(user)
                .build();
        courseRepository.save(course);
        entityManager.flush();
        entityManager.refresh(user);
        assertEquals(4, user.getCourses().size());

        // check if courses are ordered
        assertEquals("course", user.getCourses().iterator().next().getName());
    }
}
