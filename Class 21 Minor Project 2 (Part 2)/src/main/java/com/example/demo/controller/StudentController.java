package com.example.demo.controller;

import com.example.demo.dto.CreateStudentRequest;
import com.example.demo.dto.SearchRequest;
import com.example.demo.models.Book;
import com.example.demo.models.SecuredUser;
import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.util.Constants;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    // create student

    //User -> set id of this user in student object -> save the student object


    // SIGN UP API - OPEN FOR ALL
    @PostMapping("/create")
    public void createStudent(@RequestBody @Valid CreateStudentRequest createStudentRequest) {
        studentService.createStudent(createStudentRequest.toStudent());
    }



    //updating a student

    // findStudentById

    //findStudentByEmail

    //findStudentByRollNumber

    //findStudentByName

    @GetMapping("/profile")
    public Student findStudent() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser user = (SecuredUser) authentication.getPrincipal();
        Integer studentId = user.getStudent().getId();
        return studentService.find(studentId);
    }

    @GetMapping("/getInfo")
    public Student findStudent(@RequestBody @Valid SearchRequest searchRequest) throws Exception {
        List<Student> list = studentService.findStudent(searchRequest.getSearchKey(), searchRequest.getSearchValue());
        return list.get(0);
    }

}






//@PreAuthorize("hasAuthority(Constants.STUDENT_SELF_INFO_AUTHORITY)")

