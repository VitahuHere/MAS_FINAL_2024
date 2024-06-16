package org.miras.finalproject.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miras.finalproject.models.Course;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.description = course.getDescription();
        this.createdAt = course.getCreatedAt();
        this.updatedAt = course.getUpdatedAt();
    }
}
