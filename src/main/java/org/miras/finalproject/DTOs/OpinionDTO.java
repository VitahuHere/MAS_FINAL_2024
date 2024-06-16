package org.miras.finalproject.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miras.finalproject.models.Opinion;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpinionDTO {
    private int score;
    private String comment;

    public OpinionDTO(Opinion opinion) {
        this.score = opinion.getScore();
        this.comment = opinion.getComment();
    }
}
