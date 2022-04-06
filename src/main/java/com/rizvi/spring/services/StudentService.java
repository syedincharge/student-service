package com.rizvi.spring.services;

import com.rizvi.spring.entity.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {
	
  List<Student> getAllStudents();
  Student findByEmailId(String email);
  Student save(Student student);
  Optional<Student> findById(Long studentId);
  void deleteById(Long studentId);


  Student findByEmail(String email);
}
