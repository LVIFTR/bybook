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

    private String username;

    private String password;

    private String nickname;

    private String address;

    private String zipCode;

    private String phoneNumber;

}
