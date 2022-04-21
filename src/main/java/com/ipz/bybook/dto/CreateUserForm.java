package com.ipz.bybook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserForm {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String nickname;

}
