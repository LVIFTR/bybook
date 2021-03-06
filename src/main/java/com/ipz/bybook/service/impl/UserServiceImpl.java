package com.ipz.bybook.service.impl;

import com.ipz.bybook.domain.Role;
import com.ipz.bybook.domain.User;
import com.ipz.bybook.dto.CreateUserForm;
import com.ipz.bybook.repository.RoleRepository;
import com.ipz.bybook.repository.UserRepository;
import com.ipz.bybook.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(CreateUserForm createUserForm) {
        User user = User.builder()
                .firstName(createUserForm.getFirstName())
                .lastName(createUserForm.getLastName())
                .username(createUserForm.getUsername())
                .password(passwordEncoder.encode(createUserForm.getPassword()))
                .nickname(createUserForm.getNickname())
                .address(createUserForm.getAddress())
                .zipCode(createUserForm.getZipCode())
                .phoneNumber(createUserForm.getPhoneNumber())
                .roles(new HashSet<>(List.of(roleRepository.findById(0).get())))
                .build();

        return userRepository.save(user);
    }

    @Override
    public User findById(@NotNull Long id) {
        return findUserByIdOrThrowException(id);
    }

    @Override
    public User update(CreateUserForm user, Long id) {
        User userForDB = findUserByIdOrThrowException(id);
        User updatedUser = userForDB.toBuilder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .address(user.getAddress())
                .zipCode(user.getZipCode())
                .phoneNumber(user.getPhoneNumber())
                .build();
        return userRepository.save(updatedUser);
    }

    private User findUserByIdOrThrowException(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

}
