package com.example.demo.service;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findStudent(String searchKey, String searchValue) throws Exception {
        switch (searchKey) {
            case "name":
                return studentRepository.findStudentByName(searchValue);
            case "email":
                return studentRepository.findStudentByEmail(searchValue);
            case "rollNumber":
                return studentRepository.findStudentByRollNumber(searchValue);
            case "age":
                return studentRepository.findStudentByAge(Integer.parseInt(searchValue));
            case "id": {
                Optional<Student> student = studentRepository.findById(Integer.parseInt(searchValue));
                if(student.isPresent()) {
                    return Arrays.asList(student.get());
                } else {
                    return new ArrayList<>();
                }
            } default:
                throw new Exception("Search key is not valid " + searchKey);
        }
    }




}
