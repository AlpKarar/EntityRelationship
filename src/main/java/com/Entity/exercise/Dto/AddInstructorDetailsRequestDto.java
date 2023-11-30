package com.Entity.exercise.Dto;

import com.Entity.exercise.Model.Instructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class AddInstructorDetailsRequestDto {
    private String department;
    private long instructorId;
}
