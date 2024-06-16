package org.miras.finalproject.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miras.finalproject.models.CustomUser;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String login;
    private String fullName;

    public StudentDTO(CustomUser user) {
        this.login = user.getLogin();
        this.fullName = user.getName() + " " + user.getSurname();
    }
}
