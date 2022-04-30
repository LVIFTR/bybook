package com.ipz.bybook.service;

import com.ipz.bybook.domain.User;
import com.ipz.bybook.dto.CreateUserForm;

public interface UserService {

    User create(CreateUserForm createUserForm);

    User findById(Long id);

    User update(CreateUserForm user, Long id);

}
