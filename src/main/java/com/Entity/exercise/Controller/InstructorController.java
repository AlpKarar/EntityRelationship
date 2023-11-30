package com.Entity.exercise.Controller;

import com.Entity.exercise.Dto.AddInstructorDetailsRequestDto;
import com.Entity.exercise.Dto.AddInstructorRequestDto;
import com.Entity.exercise.Model.Instructor;
import com.Entity.exercise.Model.InstructorDetail;
import com.Entity.exercise.Service.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping()
    public ResponseEntity<Optional<List<Instructor>>> getAllInstructors() {
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }

    @GetMapping("/details")
    public ResponseEntity<Optional<List<InstructorDetail>>> getAllInstructorDetails() {
        return ResponseEntity.ok(instructorService.getAllInstructorDetails());
    }

    @PostMapping()
    public ResponseEntity<String> addInstructor(@RequestBody AddInstructorRequestDto request) {
        return ResponseEntity.ok(instructorService.addInstructor(request.getName()));
    }

    @PostMapping("/details")
    public String addInstructorDetails(@RequestBody AddInstructorDetailsRequestDto request) {
        return instructorService.addInstructorDetails(request);
    }

    @PostMapping("/{instructorId}/details/{detailsId}")
    public String addDetailsToInstructor(@PathVariable long instructorId,
                                       @PathVariable long detailsId) {
        return instructorService.addDetailsToInstructor(instructorId, detailsId);
    }
}