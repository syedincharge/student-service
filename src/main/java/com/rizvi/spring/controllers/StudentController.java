package com.rizvi.spring.controllers;

import com.rizvi.spring.entity.Student;
import com.rizvi.spring.exception.StudentNotFoundException;
import com.rizvi.spring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class StudentController {

    private StudentService studentservice;
    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentservice.getAllStudents();
    }
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) Long studentId) {
        Student student = studentservice.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException("Student with "+studentId+" is Not Found!"));
        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentservice.save(student);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) Long studentId, @Valid @RequestBody Student newstd) {
        Student stdu = studentservice.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException("Student with "+studentId+" is Not Found!"));
        stdu.setFirstName(newstd.getFirstName());
        stdu.setLastName(newstd.getLastName());
        stdu.setEmail(newstd.getEmail());
        return studentservice.save(stdu);
    }
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) Long studentId) {
        Student std = studentservice.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException("Student with "+studentId+" is Not Found!"));
        studentservice.deleteById(std.getStudentId());
        return "Student with ID :"+studentId+" is deleted";
    }



    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable("id") @Min(1) Long studentId){
        return  studentservice.findById(studentId);

    }


    @GetMapping("/email/{email}")
    public Student findByEmailId (@PathVariable("email") String email){
        return  studentservice.findByEmail(email);

    }


}
