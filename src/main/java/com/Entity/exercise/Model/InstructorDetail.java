package com.Entity.exercise.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnoreProperties("id")
    private long id;

    private String department;

    /*@OneToOne
    @JsonIgnoreProperties("instructorDetail")
    private Instructor instructor;*/
}