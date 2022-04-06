package com.rizvi.spring.services;

import com.rizvi.spring.entity.Student;
import com.rizvi.spring.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public Student save(Student Student) {
        return studentRepository.save(Student);
    }

    @Override
    public Optional<Student> findById(Long studentId) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long StudentId) {
        studentRepository.deleteById(StudentId);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }


     @Override
    public Student findByEmailId(String email) {
        return studentRepository.findByEmail(email);

    }

}