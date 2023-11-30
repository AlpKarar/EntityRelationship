package com.Entity.exercise.Controller;

import com.Entity.exercise.Dto.AddCourseRequestDto;
import com.Entity.exercise.Dto.AddCourseToStudentRequestDto;
import com.Entity.exercise.Model.Course;
import com.Entity.exercise.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public ResponseEntity<Optional<List<Course>>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping()
    public ResponseEntity<String> addCourse(@RequestBody AddCourseRequestDto request) {
        return ResponseEntity.ok(courseService.addCourse(request.getName()));
    }

    @PostMapping("/addToStudent")
    public String addCourseToStudent(@RequestBody AddCourseToStudentRequestDto request) {
        return courseService.addCourseToStudent(request);
    }
}
