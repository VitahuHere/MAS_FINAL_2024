package org.miras.finalproject.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TextTutorial extends Tutorial implements TextTutorialInterface{
    @Size(min = 100, max = 10000)
    private String text;
}
