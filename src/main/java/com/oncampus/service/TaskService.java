package com.oncampus.service;

import com.oncampus.model.Student;
import com.oncampus.model.Task;
import com.oncampus.repository.StudentRepository;
import com.oncampus.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    // Create Task
    public Task createTask(Task task) {

        Task savedTask = taskRepository.save(task);

        Student student = studentRepository
                .findByRollNo(savedTask.getRollNo())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.getTaskIds().add(savedTask.getId());

        studentRepository.save(student);

        return savedTask;
    }

    // Get All Tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get Task By Id
    public Task getTaskById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    // Get Tasks Of Student
    public List<Task> getTasksByStudent(String rollNo) {
        return studentService.getTasksByRollNo(rollNo);
    }

    // Update Task
    public Task updateTask(String id, Task updatedTask) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(updatedTask.getTitle());
        task.setCompleted(updatedTask.isCompleted());

        return taskRepository.save(task);
    }

    // Delete Task
    public String deleteTask(String id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        Student student = studentRepository.findByRollNo(task.getRollNo())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.getTaskIds().remove(task.getId());

        studentRepository.save(student);

        taskRepository.deleteById(id);

        return "Task deleted successfully";
    }
}