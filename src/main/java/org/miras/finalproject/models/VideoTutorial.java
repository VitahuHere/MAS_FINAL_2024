package org.miras.finalproject.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class VideoTutorial extends Tutorial{
    @NotNull
    private String videoUrl;
    private String extension;
}
