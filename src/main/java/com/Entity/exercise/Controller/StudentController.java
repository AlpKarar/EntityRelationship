package com.Entity.exercise.Controller;

import com.Entity.exercise.Dto.AddStudentRequestDto;
import com.Entity.exercise.Dto.AddStudentToInstructorRequestDto;
import com.Entity.exercise.Model.Student;
import com.Entity.exercise.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public ResponseEntity<Optional<List<Student>>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping()
    public ResponseEntity<String> addStudent(@RequestBody AddStudentRequestDto request) {
        return ResponseEntity.ok(studentService.addStudent(request.getName()));
    }

    @PostMapping("/addToInstructor")
    public ResponseEntity<String> addStudentToInstructor(@RequestBody AddStudentToInstructorRequestDto request) {
        String response = studentService.addStudentToInstructor(request);

        return ResponseEntity.ok(response);
    }
}
