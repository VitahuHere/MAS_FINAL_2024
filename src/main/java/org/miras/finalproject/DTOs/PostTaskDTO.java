package org.miras.finalproject.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miras.finalproject.models.TaskStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostTaskDTO {
    private String title;
    private String content;
    private TaskStatus status;
}
