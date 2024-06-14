package org.miras.finalproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 50)
    @NotNull
    private String name;

    @Size(max = 1024)
    private String description;

    @ElementCollection
    @Size(max = 10)
    @Builder.Default
    private List<String> keywords = new ArrayList<>();

    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "lecturer_login")
    @NotNull
    @Setter(AccessLevel.NONE)
    private CustomUser lecturer;

    @ManyToMany
    @JoinTable(
            name = "course_task",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "course_tutorial",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "tutorial_id")
    )
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Tutorial> tutorials = new HashSet<>();

    @OneToMany(mappedBy = "course")
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Access> accesses = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Opinion> opinions = new HashSet<>();

    @PrePersist
    @PreUpdate
    private void checkLecturer(){
        if(!lecturer.getRoles().contains(UserRole.LECTURER)){
            throw new IllegalArgumentException("Lecturer cannot be a student");
        }
    }

    public void setLecturer(CustomUser lecturer) {
        if(!lecturer.getRoles().contains(UserRole.LECTURER)){
            throw new IllegalArgumentException("Lecturer cannot be a student");
        }
        this.lecturer = lecturer;
    }

    public Set<CustomUser> getStudents() {
        Set<CustomUser> students = new HashSet<>();
        for (Access access : accesses) {
            students.add(access.getStudent());
        }
        return students;
    }
}
