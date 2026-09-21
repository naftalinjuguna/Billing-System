package com.wifi.bill.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wifi.bill.user.UserRepository;
import com.wifi.bill.user.Role;
import com.wifi.bill.user.User;


@Service
public class AuthService {

    private final UserRepository userRepository; 
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already registered!");
        }

        if (userRepository.existsByPhone(request.phone())) {
            throw new RuntimeException("Phone number already registered!");
        }

        User user = new User();

        user.setName(request.name());
        user.setEmail(request.email());
        user.setPhone(request.phone());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(Role.CUSTOMER);
        user.setEnabled(true);

        userRepository.save(user);
    }

}
