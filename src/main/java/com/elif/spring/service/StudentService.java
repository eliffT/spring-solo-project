package com.elif.spring.service;

import com.elif.spring.entity.Student;
import com.elif.spring.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor    // final alanlar için constructor üretir.
public class StudentService {

    private final StudentRepository studentRepository;

    public Student saveStudent(Student student){
        if(student.getBookList() != null){
            student.getBookList().forEach(book -> book.setStudent(student));
        }
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

}
