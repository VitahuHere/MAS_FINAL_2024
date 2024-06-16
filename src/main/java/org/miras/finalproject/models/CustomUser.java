package org.miras.finalproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.miras.finalproject.validation.NotFutureDate;
import org.miras.finalproject.validation.ValidBankNumber;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomUser {
    @Id
    @Size(min = 3, max = 100, message = "Login must be between 3 and 100 characters")
    private String login;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    @Size(min = 3, max = 100, message = "Surname must be between 3 and 100 characters")
    private String surname;

    @Email(message = "Private email should be valid")
    @NotBlank(message = "Private email cannot be blank")
    @Size(min = 3, max = 100, message = "Private email must be between 3 and 100 characters")
    private String privateEmail;

    @Size(max = 100, message = "Summary must be at most 100 characters")
    private String summary;

    @NotFutureDate(message = "Birth date cannot be in the future")
    private LocalDate birthDate;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    private static String SUFFIX = "@edu.quack.pl";

    @ValidBankNumber
    private String bankNumber;

    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    private BigDecimal salary;

    @Min(value = 1, message = "Tuition must be greater than 0")
    private static int tuition = 2000;

    @ElementCollection(targetClass = UserRole.class)
    @Size(min = 1)
    @Enumerated(EnumType.STRING)
    @JoinTable(name = "user_roles")
    @Builder.Default
    private Collection<UserRole> roles = EnumSet.of(UserRole.STUDENT);

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    private Charity charity;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    private Faculty faculty;

    @OneToMany(mappedBy = "lecturer")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    @Getter(AccessLevel.NONE)
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Opinion> opinions = new HashSet<>();

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Access> accesses = new ArrayList<>();

    @Transient
    public String getWorkEmail() {
        return login + SUFFIX;
    }

    @PrePersist
    @PreUpdate
    private void validate() {
        if (roles.contains(UserRole.LECTURER)) {
            if (bankNumber == null || bankNumber.isEmpty() || salary == null || salary.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Lecturer must have a valid bank number and salary greater than 0.");
            }
        } else {
            bankNumber = null;
            salary = null;
        }
    }

    public void setCharity(Charity charity) {
        if (charity == null) {
            this.charity = null;
            return;
        }
        if (roles.contains(UserRole.LECTURER)) {
            this.charity = charity;
        } else {
            throw new IllegalArgumentException("Only lecturer can be associated with charity");
        }
        if (faculty != null) {
            throw new IllegalArgumentException("User cannot be associated with both faculty and charity");
        }
    }

    public void setFaculty(Faculty faculty) {
        if (faculty == null) {
            this.faculty = null;
            return;
        }
        if (roles.contains(UserRole.LECTURER)) {
            this.faculty = faculty;
        } else {
            throw new IllegalArgumentException("Only lecturer can be associated with faculty");
        }
        if (charity != null) {
            throw new IllegalArgumentException("User cannot be associated with both faculty and charity");
        }
    }

    public List<Course> getCourses() {
        // sort by updatedAt
        return courses.stream()
                .sorted(Comparator.comparing(Course::getUpdatedAt).reversed())
                .toList();
    }

    public void makeLecturer() {
        roles.add(UserRole.LECTURER);
    }

    public void makeStudent() {
        roles.add(UserRole.STUDENT);
    }
}
