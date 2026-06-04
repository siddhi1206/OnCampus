package com.oncampus.repository;

import com.oncampus.model.Student;
import com.oncampus.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Student> findByRollNo(String rollNo);
}