package com.ipz.bybook.service.impl;

import com.ipz.bybook.domain.User;
import com.ipz.bybook.dto.CreateUserForm;
import com.ipz.bybook.repository.UserRepository;
import com.ipz.bybook.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(CreateUserForm createUserForm) {
        User user = User.builder()
                .firstName(createUserForm.getFirstName())
                .lastName(createUserForm.getLastName())
                .email(createUserForm.getEmail())
                .password(createUserForm.getPassword())
                .nickname(createUserForm.getNickname())
                .build();

        return userRepository.save(user);
    }

    @Override
    public User findById(@NotNull Long id) {
        return findUserByIdOrThrowException(id);
    }

    @Override
    public User update(User user) {
        User userForDB = findUserByIdOrThrowException(user.getId());
        User updatedUser = userForDB.toBuilder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .build();
        return userRepository.save(updatedUser);
    }

    private User findUserByIdOrThrowException(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

}
