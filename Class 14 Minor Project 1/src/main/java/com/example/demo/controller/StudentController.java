package com.example.demo.controller;

import com.example.demo.dto.CreateStudentRequest;
import com.example.demo.dto.SearchRequest;
import com.example.demo.models.Book;
import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    // create student
    @PostMapping("/student")
    public void createStudent(@RequestBody @Valid CreateStudentRequest createStudentRequest) {
        studentService.createStudent(createStudentRequest.toStudent());
    }

    //updating a student

    // findStudentById

    //findStudentByEmail

    //findStudentByRollNumber

    //findStudentByName
    @GetMapping("/getStudent")
    public List<Student> findStudent(@RequestBody @Valid SearchRequest searchRequest) throws Exception {
        List<Student> list = studentService.findStudent(searchRequest.getSearchKey(), searchRequest.getSearchValue());
        return list;
    }

}
