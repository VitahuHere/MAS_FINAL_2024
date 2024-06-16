package org.miras.finalproject.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miras.finalproject.models.TaskStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostTaskDTO {
    @NotBlank(message = "Title is required")
    @Size(max = 1024, message = "Title must be max 1024 characters")
    private String title;
    @NotBlank(message = "Content is required")
    @Size(max = 10000, message = "Content must be max 10000 characters")
    private String content;
    @NotBlank(message = "Status is required")
    private TaskStatus status;
}
