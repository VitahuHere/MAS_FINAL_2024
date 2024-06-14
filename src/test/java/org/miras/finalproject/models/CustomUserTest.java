package org.miras.finalproject.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.miras.finalproject.repositories.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomUserTest {
    private CustomUser user;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CustomUserRepository customUserRepository;

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
    void testGetWorkEmail() {
        assertEquals("login@edu.quack.pl", user.getWorkEmail());
    }

    @Test
    void getters(){
        assertEquals("login", user.getLogin());
        assertEquals("name", user.getName());
        assertEquals("surname", user.getSurname());
        assertEquals("email@gmail.com", user.getPrivateEmail());
        assertEquals("summary", user.getSummary());
        assertEquals(LocalDate.of(2000, 1, 1), user.getBirthDate());
        assertEquals("password", user.getPassword());
    }

    @Test
    void setters() {
        user.setLogin("login2");
        user.setName("name2");
        user.setSurname("surname2");
        user.setPrivateEmail("new@gmail.com");
        user.setSummary("new summary");
        user.setBirthDate(LocalDate.of(2000, 1, 2));
        user.setPassword("new password");

        assertEquals("login2", user.getLogin());
        assertEquals("name2", user.getName());
        assertEquals("surname2", user.getSurname());
        assertEquals("new@gmail.com", user.getPrivateEmail());
        assertEquals("new summary", user.getSummary());
        assertEquals(LocalDate.of(2000, 1, 2), user.getBirthDate());
        assertEquals("new password", user.getPassword());
    }

    @Test
    void validation(){
        assertThrows(ConstraintViolationException.class, () -> {
            CustomUser user = CustomUser.builder()
                    .login("lecturer")
                    .name("name")
                    .surname("surname")
                    .privateEmail("some@gmail.com")
                    .summary("summary")
                    .birthDate(LocalDate.of(2000, 1, 1))
                    .password("password")
                    .bankNumber("PL12345678901234567890123456")
                    .salary(new BigDecimal("1000.00"))
                    .roles(EnumSet.of(UserRole.LECTURER))
                    .build();
            entityManager.persist(user);
            entityManager.flush();
        });
        assertThrows(ConstraintViolationException.class, () -> {
            CustomUser user = CustomUser.builder()
                    .login("lecturer001")
                    .name("")
                    .surname("surname")
                    .privateEmail("some@gmail.com")
                    .summary("summary")
                    .birthDate(LocalDate.of(2000, 1, 1))
                    .password("password")
                    .bankNumber("PL12345678901234567890123456")
                    .salary(new BigDecimal("1000.00"))
                    .roles(EnumSet.of(UserRole.LECTURER))
                    .build();
            entityManager.persist(user);
            entityManager.flush();
        });
        assertThrows(ConstraintViolationException.class, () -> {
            CustomUser user = CustomUser.builder()
                    .login("lecturer002")
                    .name("name")
                    .surname("")
                    .privateEmail("some@gmail.com")
                    .summary("summary")
                    .birthDate(LocalDate.of(2000, 1, 1))
                    .password("password")
                    .bankNumber("PL12345678901234567890123456")
                    .salary(new BigDecimal("1000.00"))
                    .roles(EnumSet.of(UserRole.LECTURER))
                    .build();
            entityManager.persist(user);
            entityManager.flush();
        });
        assertThrows(ConstraintViolationException.class, () -> {
            CustomUser user = CustomUser.builder()
                    .login("lecturer003")
                    .name("name")
                    .surname("surname")
                    .privateEmail("some")
                    .summary("summary")
                    .birthDate(LocalDate.of(2000, 1, 1))
                    .password("password")
                    .bankNumber("PL12345678901234567890123456")
                    .salary(new BigDecimal("1000.00"))
                    .roles(EnumSet.of(UserRole.LECTURER))
                    .build();
            entityManager.persist(user);
            entityManager.flush();
        });
        assertThrows(ConstraintViolationException.class, () -> {
            CustomUser user = CustomUser.builder()
                    .login("lecturer004")
                    .name("name")
                    .surname("surname")
                    .privateEmail("some@gmail.com")
                    .summary("summary")
                    .birthDate(LocalDate.of(3000, 1, 1))
                    .password("password")
                    .bankNumber("PL12345678901234567890123456")
                    .salary(new BigDecimal("1000.00"))
                    .roles(EnumSet.of(UserRole.LECTURER))
                    .build();
            entityManager.persist(user);
            entityManager.flush();
        });
        assertThrows(ConstraintViolationException.class, () -> {
            CustomUser user = CustomUser.builder()
                    .login("lecturer005")
                    .name("name")
                    .surname("surname")
                    .privateEmail("some@gmail.com")
                    .summary("summary")
                    .birthDate(LocalDate.of(2000, 1, 1))
                    .password("pas")
                    .bankNumber("PL12345678901234567890123456")
                    .salary(new BigDecimal("1000.00"))
                    .roles(EnumSet.of(UserRole.LECTURER))
                    .build();
            entityManager.persist(user);
            entityManager.flush();
        });
    }

    @Test
    void testPersistence(){
        entityManager.persist(user);
        entityManager.flush();
        CustomUser found = customUserRepository.findByLogin("login");
        assertEquals(user, found);
    }
}