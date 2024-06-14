package org.miras.finalproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Solution {
    @Id
    private Long id;
    @NotNull
    @Size(max = 2000)
    private String solution;
    @Size(max = 5000)
    private String explanation;

    @NotNull
    @ManyToOne
    @Setter(AccessLevel.NONE)
    private Task task;
}
