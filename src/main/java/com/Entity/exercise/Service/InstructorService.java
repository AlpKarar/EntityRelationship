package com.Entity.exercise.Service;

import com.Entity.exercise.Dto.AddInstructorDetailsRequestDto;
import com.Entity.exercise.Model.Instructor;
import com.Entity.exercise.Model.InstructorDetail;
import com.Entity.exercise.Repository.InstructorDetailRepository;
import com.Entity.exercise.Repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorDetailRepository instructorDetailRepository;

    public InstructorService(InstructorRepository instructorRepository,
                             InstructorDetailRepository instructorDetailRepository) {
        this.instructorRepository = instructorRepository;
        this.instructorDetailRepository = instructorDetailRepository;
    }

    public Optional<List<Instructor>> getAllInstructors() {
        return Optional.of(instructorRepository.findAll());
    }

    public String addInstructor(String name) {
        instructorRepository.save(new Instructor(name));

        return "Instructor saved";
    }

    public String addDetailsToInstructor(long instructorId, long detailsId) {
        InstructorDetail instructorDetail;

        try {
            instructorDetail = instructorDetailRepository.findById(detailsId).get();
        } catch (NoSuchElementException e) {
            return "Instruction Detail does not exist";
        }

        Instructor instructor;

        try {
            instructor = instructorRepository.findById(instructorId).get();
        } catch (NoSuchElementException e) {
            return "No such an Instruction exist";
        }

        instructor.setInstructorDetail(instructorDetail);

        instructorRepository.save(instructor);

        return "Instructor detail added to the related instructor";
    }

    public String addInstructorDetails(AddInstructorDetailsRequestDto request) {
        InstructorDetail instructorDetail = new InstructorDetail();

        String department = request.getDepartment();

        try {
            Optional<Instructor> instructor = Optional.of(instructorRepository.findById(request.getInstructorId()))
                    .orElseGet(() -> Optional.of(new Instructor()));

            instructorDetail.setDepartment(department);

            //instructorDetail.setInstructor(instructor.get());

            instructorDetailRepository.save(instructorDetail);
        } catch (NoSuchElementException e) {
            return "No such an Instructor exist";
        }

        return "Instructor detail added";
    }

    public Optional<List<InstructorDetail>> getAllInstructorDetails() {
        return Optional.of(instructorDetailRepository.findAll());
    }
}
