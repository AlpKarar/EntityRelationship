package com.Entity.exercise.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddCourseToStudentRequestDto {
    private long courseId;
    private long studentId;
}
