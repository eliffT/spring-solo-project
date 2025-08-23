package com.elif.spring.controller;

import com.elif.spring.entity.Student;
import com.elif.spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/list")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

}
