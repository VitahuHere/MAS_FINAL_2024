package org.miras.finalproject.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miras.finalproject.models.Task;
import org.miras.finalproject.models.TaskStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTaskDTO {
    private Long id;
    private String title;
    private TaskStatus status;

    public GetTaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.status = task.getStatus();
    }
}
