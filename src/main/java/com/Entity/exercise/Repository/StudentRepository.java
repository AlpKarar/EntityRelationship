package com.Entity.exercise.Repository;

import com.Entity.exercise.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
