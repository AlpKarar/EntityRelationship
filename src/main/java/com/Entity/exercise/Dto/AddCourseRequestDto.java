package com.Entity.exercise.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddCourseRequestDto {

    private String name;

    public AddCourseRequestDto(String name) {
        this.name = name;
    }
}
