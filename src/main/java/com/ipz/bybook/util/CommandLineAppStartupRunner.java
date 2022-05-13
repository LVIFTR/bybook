package com.ipz.bybook.util;

import com.ipz.bybook.domain.Role;
import com.ipz.bybook.domain.User;
import com.ipz.bybook.repository.RoleRepository;
import com.ipz.bybook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public CommandLineAppStartupRunner(
            UserRepository userRepository,
            RoleRepository roleRepository,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String...args) {
        Role adminRole = Role.builder()
                .id(1)
                .name("ADMIN")
                .build();
        if (roleRepository.findAll().isEmpty()){
            Role user = Role.builder()
                    .id(0)
                    .name("USER")
                    .build();
            roleRepository.save(user);
        }
        if (userRepository.findByUsername("admin@admin").isEmpty()) {
            User admin = User.builder()
                    .firstName("System")
                    .lastName("Administrator")
                    .username("admin@admin")
                    .password(passwordEncoder.encode("admin"))
                    .nickname("admin")
                    .address("Local bookstore address")
                    .zipCode("00000")
                    .phoneNumber("0000000000")
                    .roles(new HashSet<>(List.of(adminRole)))
                    .build();
            userRepository.save(admin);
        }
    }
}
