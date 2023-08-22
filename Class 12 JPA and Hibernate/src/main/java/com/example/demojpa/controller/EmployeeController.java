package com.example.demojpa.controller;

import com.example.demojpa.dto.CreateEmployeeRequest;

import com.example.demojpa.model.Employee;
import com.example.demojpa.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public String createEmployee(@RequestBody @Valid CreateEmployeeRequest employeeRequest) {
        // conversion of DTO to a model
        Employee employee = employeeRequest.toEmployee();
        employeeService.save(employee);
        return "Accepted";
    }

}
