package com.ipz.bybook.util;

import com.ipz.bybook.domain.User;
import com.ipz.bybook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public CommandLineAppStartupRunner(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String...args) {
        if (userRepository.findByUsername("admin@admin.com").isEmpty()) {
            User admin = User.builder()
                    .firstName("System")
                    .lastName("Administrator")
                    .username("admin@admin")
                    .password(passwordEncoder.encode("admin"))
                    .nickname("admin")
                    .address("Local bookstore address")
                    .zipCode("00000")
                    .phoneNumber("0000000000")
                    .role("ADMIN")
                    .build();
            userRepository.save(admin);
        }
    }
}
