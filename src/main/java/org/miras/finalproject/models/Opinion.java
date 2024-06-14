package org.miras.finalproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.miras.finalproject.repositories.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id", "course_id"})
})
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Range(min = 1, max = 5)
    private int rate;
    @Size(max = 250)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @NotNull
    private CustomUser student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @NotNull
    private Course course;
}
