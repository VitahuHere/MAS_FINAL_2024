package org.miras.finalproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(max = 1024)
    private String title;
    @NotNull
    @Size(max = 10000)
    private String content;
    @Builder.Default
    @NotNull
    private TaskStatus status = TaskStatus.DRAFT;

    @ManyToMany
    @JoinTable(
            name = "course_task",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "task")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Solution> solutions = new HashSet<>();

    public void setAsDraft() {
        this.status = TaskStatus.DRAFT;
    }

    public void setAsPublished() {
        this.status = TaskStatus.PUBLISHED;
    }

    public void setAsArchived() {
        this.status = TaskStatus.ARCHIVED;
    }
}
