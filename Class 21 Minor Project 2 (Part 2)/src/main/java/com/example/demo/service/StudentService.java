package com.example.demo.service;

import com.example.demo.models.SecuredUser;
import com.example.demo.models.Student;
import com.example.demo.repository.StudentCacheRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.util.Constants;
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

    @Autowired
    StudentCacheRepository studentCacheRepository;

    @Autowired
    UserService userService;

    // Student -> user -> set userid in student object -> save student
    public void createStudent(Student student) {
        SecuredUser securedUser = student.getSecuredUser();
        securedUser = userService.save(securedUser, Constants.STUDENT_USER);

        student.setSecuredUser(securedUser);
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

    public Student find(Integer studentId) {
        Student student = studentCacheRepository.get(studentId);
        if(student != null) {
            return student;
        }

        student = studentRepository.findById(studentId).orElse(null);
        if(student != null) {
            studentCacheRepository.set(student);
        }
        return student;
    }


    // check cache -> if data is present in cache -> return it
//                        get it from db -> add it to cache and return it

}
