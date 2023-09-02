package com.example.demojpa.service;

import com.example.demojpa.daos.EmployeeRepository;
import com.example.demojpa.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    // Select * from employee;
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    // Select * from employee where id = <employeeId>
    public Optional<Employee> getById(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployee(Integer employeeId, Employee employee) {
        employee.setId(employeeId);
        employeeRepository.save(employee);
    }

    public List<Employee> findBy(String name, Integer age, String address) {
        return employeeRepository.findByNameAndAgeAndAddress(name, age, address);
    }

}
