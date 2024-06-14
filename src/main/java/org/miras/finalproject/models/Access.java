package org.miras.finalproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    private LocalDate purchaseDate;

    @ManyToOne
    @JoinColumn(name = "student_login", nullable = false)
    @NotNull
    private CustomUser student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @NotNull
    private Course course;
}
