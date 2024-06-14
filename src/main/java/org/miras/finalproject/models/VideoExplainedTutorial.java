package org.miras.finalproject.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class VideoExplainedTutorial extends VideoTutorial implements TextTutorialInterface{
    @ElementCollection
    @Size(max = 100)
    private List<Integer> keyFrames = new ArrayList<>();

    @Size(min = 100, max = 10000)
    private String text;
}
