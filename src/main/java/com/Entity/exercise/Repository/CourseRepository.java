package com.Entity.exercise.Repository;

import com.Entity.exercise.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
