package com.Entity.exercise.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JsonIgnoreProperties("students")
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany
            @JoinTable(name = "student_courses",
            joinColumns = @JoinColumn(name = "student"),
            inverseJoinColumns = @JoinColumn(name = "courses"))
    @JsonIgnoreProperties("students")
    List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }
}
