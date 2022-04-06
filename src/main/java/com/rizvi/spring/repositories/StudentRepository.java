package com.rizvi.spring.repositories;

import com.rizvi.spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {


    public Student findByEmail(String email);
}
