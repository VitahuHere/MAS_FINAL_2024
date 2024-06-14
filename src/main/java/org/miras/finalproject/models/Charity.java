package org.miras.finalproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Charity {
    @Id
    @NotNull
    @Size(min = 10, max = 10)
    private String NIP;
    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @OneToMany(mappedBy = "charity")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<CustomUser> lecturers = new HashSet<>();
}
