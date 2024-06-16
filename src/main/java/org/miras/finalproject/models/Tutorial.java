package org.miras.finalproject.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Tutorial {
    @Id
    private Long id;

    @Range(min = 1, max = 10)
    private int difficulty;

    @ManyToMany
    @JoinTable(
            name = "course_tutorial",
            joinColumns = @JoinColumn(name = "tutorial_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    Set<Course> courses = new HashSet<>();
}
