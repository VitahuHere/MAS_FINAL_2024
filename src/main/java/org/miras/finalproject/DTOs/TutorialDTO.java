package org.miras.finalproject.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miras.finalproject.models.TextTutorial;
import org.miras.finalproject.models.VideoExplainedTutorial;
import org.miras.finalproject.models.VideoTutorial;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorialDTO {
    private String type;
    private String details;

    public TutorialDTO(TextTutorial tutorial) {
        this.type = "Text";
        this.details = tutorial.getText();
    }

    public TutorialDTO(VideoTutorial tutorial) {
        this.type = "Video";
        this.details = tutorial.getVideoUrl();
    }

    public TutorialDTO(VideoExplainedTutorial tutorial) {
        this.type = "Text+Video";
        this.details = tutorial.getText();
    }
}
