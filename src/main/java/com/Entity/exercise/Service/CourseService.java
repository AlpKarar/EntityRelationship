package com.Entity.exercise.Service;

import com.Entity.exercise.Dto.AddCourseToStudentRequestDto;
import com.Entity.exercise.Model.Course;
import com.Entity.exercise.Model.Student;
import com.Entity.exercise.Repository.CourseRepository;
import com.Entity.exercise.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseService(CourseRepository courseRepository,
                         StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public Optional<List<Course>> getAllCourses() {
        return Optional.of(courseRepository.findAll());
    }

    public String addCourse(String name) {
        courseRepository.save(new Course(name));

        return "Course saved";
    }

    public String addCourseToStudent(AddCourseToStudentRequestDto request) {
        long courseId = request.getCourseId();
        long studentId = request.getStudentId();

        Course course;

        try {
            course = courseRepository.findById(courseId).get();
        } catch (NoSuchElementException e) {
            return "No such a Course exist";
        }

        Student student;

        try {
            student = studentRepository.findById(studentId).get();
        } catch (NoSuchElementException e) {
            return "No such a Student exist";
        }

        List<Student> students = course.getStudents();
        students.add(student);
        course.setStudents(students);

        courseRepository.save(course);

        List<Course> courses = student.getCourses();
        courses.add(course);
        student.setCourses(courses);

        studentRepository.save(student);

        return "Student added to Course and Course added to Student";
    }
}
