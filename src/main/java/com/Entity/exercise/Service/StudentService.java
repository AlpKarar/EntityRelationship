package com.Entity.exercise.Service;

import com.Entity.exercise.Dto.AddStudentToInstructorRequestDto;
import com.Entity.exercise.Model.Instructor;
import com.Entity.exercise.Model.Student;
import com.Entity.exercise.Repository.InstructorRepository;
import com.Entity.exercise.Repository.StudentRepository;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;

    public StudentService(StudentRepository studentRepository,
                          InstructorRepository instructorRepository) {
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
    }

    public Optional<List<Student>> getAllStudents() {
        return Optional.of(studentRepository.findAll());
    }

    public String addStudent(String name) {
        studentRepository.save(new Student(name));

        return "Student saved";
    }

    public String addStudentToInstructor(AddStudentToInstructorRequestDto request) {
        long studentId = request.getStudentId();
        long instructorId = request.getInstructorId();

        System.out.println("Student ID: " + studentId);
        System.out.println("Instructor ID: " + instructorId);
        System.out.println("---------------------------------");

        Student student;

        try {
            student = studentRepository.findById(studentId).get();
        } catch (NoSuchElementException e) {
            return "No such an Student exist";
        }

        Instructor instructor;

        try {
            instructor = instructorRepository.findById(instructorId).get();
        } catch (NoSuchElementException e) {
            return "No such an Instructor exist";
        }

        List<Student> allStudents = instructor.getStudents();
        allStudents.add(student);
        instructor.setStudents(allStudents);

        instructorRepository.save(instructor);

        student.setInstructor(instructor);

        studentRepository.save(student);

        return "Student added to the Instructor";
    }
}
