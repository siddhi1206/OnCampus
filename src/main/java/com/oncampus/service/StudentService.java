package com.oncampus.service;

import com.oncampus.model.Student;
import com.oncampus.model.Task;
import com.oncampus.repository.StudentRepository;
import com.oncampus.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final TaskRepository taskRepository;

    public List<Task> getTasksByRollNo(String rollNo) {

        Student student = studentRepository.findByRollNo(rollNo)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));

        List<String> taskIds = student.getTaskIds();

        List<Task> tasks = new ArrayList<>();

        for (String taskId : taskIds) {
            taskRepository.findById(taskId).ifPresent(tasks::add);
        }

        return tasks;
    }
}