package com.Entity.exercise.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddStudentRequestDto {

    private String name;

    public AddStudentRequestDto(String name) {
        this.name = name;
    }
}
