package com.example.demojpa.controller;

import com.example.demojpa.dto.CreateEmployeeRequest;

import com.example.demojpa.dto.GetEmployeesResponse;
import com.example.demojpa.model.Employee;
import com.example.demojpa.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/employee/all")
    public GetEmployeesResponse getEmployees() {
        // conversion of model to a dto
        return GetEmployeesResponse.builder().
                employeeList(employeeService.getAll())
                .build();
    }

    @GetMapping("/employee/{id}")
    public GetEmployeesResponse getEmployee(@PathVariable("id") Integer employeeId) {
        // conversion of DTO to a model
        Optional<Employee> employee = employeeService.getById(employeeId);
        List<Employee> employeeList = employee.isPresent() ? Arrays.asList(employee.get()) : new ArrayList<>();
        return GetEmployeesResponse.builder().
                employeeList(employeeList)
                .build();
    }

    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestParam("id") Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable("id") Integer employeeId,
                               @RequestBody CreateEmployeeRequest employeeRequest) {
        employeeService.updateEmployee(employeeId, employeeRequest.toEmployee());
    }

    @GetMapping("/employee/findBy")
    public GetEmployeesResponse findBy(@RequestParam("name") String name, @RequestParam("age") Integer age, @RequestParam("address") String address) {
        // conversion of model to a dto
        return GetEmployeesResponse.builder().
                employeeList(employeeService.findBy(name, age, address))
                .build();
    }

}
