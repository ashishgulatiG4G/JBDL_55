package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private DbOperation dbOperation;

    public EmployeeController() {
//        dbOperation = new DbOperation();
    }

    @PostMapping("/createEmployee")
    public void createEmployee(@RequestBody Employee employee) throws SQLException {
        dbOperation.createEmployee(employee);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() throws SQLException {
        return dbOperation.getEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id) throws SQLException {
        return dbOperation.getEmployeeById(id);
    }

    @GetMapping("/getEmployeeByName/{name}")
    public Employee getEmployeeById(@PathVariable("name") String name) throws SQLException {
        return dbOperation.getEmployeeByName(name);
    }


    @PutMapping("/employee/id/{id}")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return null;
    }

    @PatchMapping("/employee/id/{id}")
    public Employee patchUpdateEmployee(@RequestBody Employee employee) {
        return null;
    }

    @DeleteMapping("/employee/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        return null;
    }



}
