package com.example.server.controller;

import com.example.server.model.Student;
import com.example.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentFindById(@PathVariable("id") Long studentId){
        return studentRepository.findById(studentId);
    }

    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }


}
