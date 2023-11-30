package com.Entity.exercise.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddInstructorRequestDto {

    private String name;

    public AddInstructorRequestDto(String name) {
        this.name = name;
    }
}
