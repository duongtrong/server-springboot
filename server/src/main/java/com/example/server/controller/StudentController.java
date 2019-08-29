package com.example.server.controller;

import com.example.server.exception.MyResourceNotFoundException;
import com.example.server.model.Student;
import com.example.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
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
    public Student getStudentFindById(@PathVariable("id") Long studentId){
        return studentRepository.findById(studentId).orElseThrow (() -> new MyResourceNotFoundException (studentId));
    }

    @PostMapping("/students")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long studentId) {
        return studentRepository.findById(studentId)
                .map(s -> {
                    s.setRollNumber(student.getRollNumber());
                    s.setFullName(student.getFullName());
                    s.setEmail(student.getEmail());
                    s.setPhoneNumber(student.getPhoneNumber());
                    s.setAddress(student.getAddress());
                    return studentRepository.save(s);
                }).orElseGet(() -> {
                    student.setId(studentId);
                    return studentRepository.save(student);
                });
    }


    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
