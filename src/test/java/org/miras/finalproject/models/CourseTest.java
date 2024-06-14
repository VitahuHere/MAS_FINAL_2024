package org.miras.finalproject.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.miras.finalproject.repositories.CourseRepository;
import org.miras.finalproject.repositories.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CourseTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CustomUserRepository customUserRepository;

    private Course course;
    private CustomUser lecturer;

    @BeforeEach
    void setUp() {
        lecturer = customUserRepository.findByLogin("lecturer");
        course = Course.builder()
                .name("Course")
                .description("Description")
                .lecturer(lecturer)
                .build();
    }

    @Test
    void testChangeLecturer() {
        CustomUser newLecturer = customUserRepository.findByLogin("lecturer1");
        course.setLecturer(newLecturer);
        courseRepository.save(course);
        entityManager.flush();
        entityManager.refresh(newLecturer);
        assertEquals(2, newLecturer.getCourses().size());

        CustomUser student = customUserRepository.findByLogin("student");
        assertThrows(IllegalArgumentException.class, () -> course.setLecturer(student));
    }

    @Test
    void testGetAccesses() {
        Course course1 = courseRepository.findById(10001L).orElse(null);
        assertNotNull(course1);
        assertEquals(1, course1.getAccesses().size());
        Access access = Access.builder()
                .course(course1)
                .student(customUserRepository.findByLogin("student"))
                .build();
        entityManager.persist(access);
        entityManager.flush();
        entityManager.refresh(course1);
        assertEquals(2, course1.getAccesses().size());
    }

    @Test
    void testGetOpinions() {
        Course course1 = courseRepository.findById(10001L).orElse(null);
        assertNotNull(course1);
        assertEquals(0, course1.getOpinions().size());
        Opinion opinion = Opinion.builder()
                .rate(5)
                .course(course1)
                .student(customUserRepository.findByLogin("student"))
                .build();
        entityManager.persist(opinion);
        entityManager.flush();
        entityManager.refresh(course1);
        assertEquals(1, course1.getOpinions().size());
    }

    @Test
    void testGetTasks() {
        Course course1 = courseRepository.findById(10001L).orElse(null);
        assertNotNull(course1);
        assertEquals(0, course1.getTasks().size());
        Task task = Task.builder()
                .title("Task")
                .content("Content")
                .status(TaskStatus.DRAFT)
                .courses(Set.of(course1))
                .build();
        entityManager.persist(task);
        entityManager.flush();
        entityManager.refresh(course1);
        assertEquals(1, course1.getTasks().size());
    }

    @Test
    void getStudents(){
        Course course1 = courseRepository.findById(10001L).orElse(null);
        assertNotNull(course1);
        assertEquals(1, course1.getStudents().size());
        Access access = Access.builder()
                .course(course1)
                .student(customUserRepository.findByLogin("student"))
                .build();
        entityManager.persist(access);
        entityManager.flush();
        entityManager.refresh(course1);
        assertEquals(1, course1.getStudents().size());
    }
}
