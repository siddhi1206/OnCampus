package com.oncampus.service;

import com.oncampus.dto.RegisterRequest;
import com.oncampus.model.Role;
import com.oncampus.model.User;
import com.oncampus.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerEducator(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        user.setRole(Role.EDUCATOR);
        user.setApproved(false);

        return userRepository.save(user);
    }
}
