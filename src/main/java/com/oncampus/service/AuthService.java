package com.oncampus.service;

import com.oncampus.dto.LoginRequest;
import com.oncampus.dto.StudentSignupRequest;
import com.oncampus.model.Role;
import com.oncampus.model.Student;
import com.oncampus.model.User;
import com.oncampus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public String registerStudent(StudentSignupRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setPassword(request.getPassword());

        student.setBranch(request.getBranch());
        student.setYear(request.getYear());
        student.setRollNo(request.getRollNo());

        student.setRole(Role.STUDENT);
        student.setApproved(true);

        userRepository.save(student);

        return "Student registered successfully";
    }

    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        if (user.getRole() != Role.STUDENT) {
            throw new IllegalArgumentException("Access denied");
        }

        return "Login successful";
    }
}